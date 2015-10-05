package com.concord;

import com.concord.Computation;
import com.concord.swift.ComputationService;
import com.concord.swift.Constants;
import com.concord.swift.Endpoint;
import com.facebook.swift.service.*;
import com.facebook.swift.codec.*;
import com.google.common.base.Preconditions;
import java.util.ArrayList;

public class ThriftService {
  private ThriftServer server;

  public ThriftService(Computation c, Endpoint listen, Endpoint proxy) {
    Preconditions.checkNotNull(c);
    Preconditions.checkNotNull(listen);
    Preconditions.checkNotNull(proxy);
    ThriftServiceProcessor processor = new ThriftServiceProcessor(
        new ThriftCodecManager(), new ArrayList<ThriftEventHandler>(),
        new ComputationWrapper(c, proxy));

    ThriftServerConfig serverConfig = new ThriftServerConfig()
                                          .setBindAddress(listen.getIp())
                                          .setPort(listen.getPort());
    try {
      this.server = new ThriftServer(processor, serverConfig);
    } catch (Throwable t) {
      System.err.println("Error creating thrift service: " + t);
      System.exit(1);
    }
  }

  public void serve() { this.server.start(); }
  public void stop() { this.server.close(); }
}
