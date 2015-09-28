/**
 * ComputationWrapper class for Concord
 * Synopsis: Wrapper around user Computation. Interfaces with thrift server.
 */

package com.concord;

import com.concord.Metadata;
import com.concord.ComputationContextImpl;
import com.concord.Tuple;

import com.concord.swift.*;
import com.facebook.swift.service.*;
import com.facebook.nifty.client.FramedClientConnector;
import com.google.common.net.HostAndPort;
import org.apache.thrift.TException;

import java.util.*;

public class ComputationWrapper implements ComputationService {

  /** Reference to user defined computation */
  private final Computation userService;

  /** Thrift client that will perform async RPC */
  private final BoltProxyService client;

  /** ip and port of proxy */
  private final Endpoint proxyInfo;

  public ComputationWrapper(Computation c, Endpoint proxyInfo) {
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
    } catch (BoltError userError) {
      ;
    } catch (TException thriftException) {
      ;
    } catch (Exception exception) {
      ;
    }
    this.client = client;
  }

  public ComputationTx init() throws BoltError {
    ComputationContextImpl ctx = new ComputationContextImpl(client);
    try {
      this.userService.init(ctx);
    } catch (Exception userException) {
      System.out.println(userException);
      System.out.println("Exception in client init");
      System.exit(1);
    }
    return new ComputationTx.Builder()
      .setRecords(ctx.getRecords())
      .setTimers(ctx.getTimers())
      .build();
  }

  public ComputationTx boltProcessTimer(String key, long time) throws BoltError {
    ComputationContextImpl ctx = new ComputationContextImpl(client);
    try {
      this.userService.processTimer(ctx, key, time);
    } catch (Exception userException) {
      System.out.println(userException);
      System.out.println("Exception in client processTimer");
      System.exit(1);
    }
    return new ComputationTx.Builder()
      .setRecords(ctx.getRecords())
      .setTimers(ctx.getTimers())
      .build();
  }

  public List<ComputationTx> boltProcessRecords(List<Record> records)
    throws BoltError {
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
    } catch (Exception userException) {
      System.out.println(userException);
      System.out.println("Exception in client processTimer");
      System.exit(1);
    }
    return ctxs;
  }

  public ComputationMetadata boltMetadata() throws BoltError {
    try {
      System.out.println("Getting client metadata");
      Metadata metadata = this.userService.metadata();

      ComputationMetadata cpmd = new ComputationMetadata.Builder()
        .setName(metadata.name)
        .setIstreams(enrichStream(metadata.istreams))
        .setOstreams(new ArrayList<String>(metadata.ostreams))
        .setProxyEndpoint(this.proxyInfo)
        .build();
      System.out.println("Metadata fetched: " + cpmd.toString());
      return cpmd;
    } catch (Exception userException) {
      System.out.println(userException);
      System.exit(1);
    }
    return null;
  }

  private static List<StreamMetadata> enrichStream(
    Set<Tuple<String, StreamGrouping> > stream) {
    List<StreamMetadata> smd = new ArrayList<StreamMetadata>();

    for (Tuple<String, StreamGrouping> it : stream) {
      smd.add(new StreamMetadata.Builder()
              .setName(it.first)
              .setGrouping(it.second)
              .build());
    }
    return smd;
  }

  public void close() {}

}
