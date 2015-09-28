/**
 * Serve Computation class for Concord
 * Synopsis: Serves a computation for consumption in concord
 */

package com.concord;
import com.concord.Computation;
import com.concord.swift.ComputationService;
import com.concord.swift.Constants;
import com.concord.swift.Endpoint;

import com.facebook.swift.service.*;
import com.facebook.swift.codec.*;

import java.util.ArrayList;

public class ThriftService {

  private final ThriftServer server;

  /**
   * Creates a new thrift server
   */
  public ThriftService(Computation c, Endpoint listen, Endpoint proxy) {
    ThriftServiceProcessor processor = new ThriftServiceProcessor(
      new ThriftCodecManager(),
      new ArrayList<ThriftEventHandler>(),
      new ComputationWrapper(c, proxy)
    );

    ThriftServerConfig serverConfig = new ThriftServerConfig()
      .setBindAddress(listen.getIp())
      .setPort(listen.getPort());

    this.server = new ThriftServer(processor, serverConfig);
  }

  /**
   * Starts the thrift server.
   */
  public void serve() {
    System.out.println("Starting service");
    server.start();
  }

  /**
   * Stops the thrift server
   */
  public void stop() {
    System.out.println("Stopping service");
    server.close();
  }
}
