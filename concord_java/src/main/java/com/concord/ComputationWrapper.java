package com.concord;

import com.concord.Metadata;
import com.concord.ComputationContextImpl;
import com.concord.StreamTuple;
import com.concord.swift.*;
import com.facebook.swift.service.*;
import com.facebook.nifty.client.FramedClientConnector;
import com.google.common.net.HostAndPort;
import org.apache.thrift.TException;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import java.util.*;

public class ComputationWrapper implements ComputationService {

  /** Reference to user defined computation */
  private final Computation userService;

  /** Thrift client that will perform async RPC */
  private final BoltProxyService client;

  /** ip and port of proxy */
  private final Endpoint proxyInfo;

  public ComputationWrapper(Computation c, Endpoint proxyInfo) {
    Preconditions.checkNotNull(c);
    Preconditions.checkNotNull(proxyInfo);
    this.userService = c;
    this.proxyInfo = proxyInfo;

    BoltProxyService client = null;
    try {
      FramedClientConnector connector = new FramedClientConnector(
        HostAndPort.fromParts(proxyInfo.getIp(), proxyInfo.getPort()));
      client = new ThriftClientManager()
        .createClient(connector, BoltProxyService.class)
        .get();
      client.registerWithScheduler(this.boltMetadata());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    Preconditions.checkNotNull(client);
    this.client = client;
  }

  public ComputationTx init() {
    ComputationContextImpl ctx = new ComputationContextImpl(this.client);
    try {
      this.userService.init(ctx);
    } catch (Exception e) {
      System.err.println("Exception in client init: " + e);
      System.exit(1);
    }
    return new ComputationTx.Builder()
      .setRecords(ctx.getRecords())
      .setTimers(ctx.getTimers())
      .build();
  }

  public ComputationTx boltProcessTimer(String key, long time) {
    Preconditions.checkNotNull(key);
    ComputationContextImpl ctx = new ComputationContextImpl(client);
    try {
      this.userService.processTimer(ctx, key, time);
    } catch (Exception e) {
      System.err.println("Exception in client processTimer: " + e);
      System.exit(1);
    }
    return new ComputationTx.Builder()
      .setRecords(ctx.getRecords())
      .setTimers(ctx.getTimers())
      .build();
  }

  public List<ComputationTx> boltProcessRecords(List<Record> records) {
    List<ComputationTx> ctxs = new ArrayList<ComputationTx>();
    try {
      for (Record r : records) {
        ComputationContextImpl ctx = new ComputationContextImpl(client);
        this.userService.processRecord(ctx, r);
        ctxs.add(new ComputationTx.Builder()
                 .setRecords(ctx.getRecords())
                 .setTimers(ctx.getTimers())
                 .build());
      }
    } catch (Exception e) {
      System.err.println("Exception in client processTimer: " + e);
      System.exit(1);
    }
    return ctxs;
  }

  public ComputationMetadata boltMetadata() {
    try {
      Metadata metadata = this.userService.metadata();
      return new ComputationMetadata.Builder()
        .setName(metadata.name)
        .setIstreams(enrichStream(metadata.istreams))
        .setOstreams(new ArrayList<String>(metadata.ostreams))
        .setProxyEndpoint(this.proxyInfo)
        .build();
    } catch (Exception e) {
      System.err.println("Exception generating metadata: " + e);
      System.exit(1);
    }
    // compiler happy
    return null;
  }

  private static List<StreamMetadata> enrichStream(
    Set<StreamTuple> streams) {
    List<StreamMetadata> smd = new ArrayList<StreamMetadata>();

    for (StreamTuple it : streams) {
      smd.add(new StreamMetadata.Builder()
              .setName(it.streamName)
              .setGrouping(it.grouping)
              .build());
    }
    return smd;
  }

  public void close() {}

}
