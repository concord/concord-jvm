package com.concord;

import com.concord.Computation;
import com.concord.ThriftService;
import com.concord.swift.Endpoint;
import com.concord.swift.Constants;
import com.google.common.base.Verify;
import com.google.common.base.Preconditions;

/**
 * `ServeComputation`
 *
 * Entry point for launching a computation in concord
 * Create your own concrete subclass of `Computation` implementing
 * the abstract methods, and pass an instance to `ServeComputation.serve`.
 */
public class ServeComputation {

  private static Endpoint addrStringToEndpoint(String addrStr) {
    Preconditions.checkNotNull(addrStr);
    String[] contents = System.getenv(addrStr).split(":", 2);
    Verify.verify(contents.length == 2, "Cannot get ip:port for listen addr");

    return new Endpoint.Builder()
      .setIp(contents[0])
      .setPort(Short.parseShort(contents[1]))
      .build();
  }

  /**
   * Launch a computation
   * @param c: Computation to run on concord.
   */
  public static void serve(Computation c) {
    Preconditions.checkNotNull(c);
    Endpoint listen = addrStringToEndpoint(
      System.getenv(Constants.kConcordEnvKeyClientListenAddr));
    Endpoint proxy = addrStringToEndpoint(
      System.getenv(Constants.kConcordEnvKeyClientProxyAddr));

    ThriftService tserver = new ThriftService(c, listen, proxy);
    tserver.serve();
  }

}
