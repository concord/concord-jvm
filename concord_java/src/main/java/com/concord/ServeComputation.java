/**
 * Serve Computation class for Concord
 * Synopsis: Serves a computation for consumption in concord
 */

package com.concord;

import com.concord.Computation;
import com.concord.ThriftService;

import com.concord.swift.Endpoint;
import com.concord.swift.Constants;

/**
 * `ServeComputation`
 *
 * Entry point for launching a computation in concord
 * Create your own concrete subclass of `Computation` implementing
 * the abstract methods, and pass an instance to `ServeComputation.serve`.
 */
public class ServeComputation {

  private static Endpoint addrStringToEndpoint(String addrStr) {
    String[] contents = System.getenv(Constants.kConcordEnvKeyClientListenAddr)
      .split(":", 2);
    if (contents.length != 2) {
      return null;
    }
    return new Endpoint.Builder()
      .setIp(contents[0])
      .setPort(Short.parseShort(contents[1]))
      .build();
  }

  /**
   * Launch a computation
   *
   * @param c: Computation to run on concord.
   */
  public static void serve(Computation c) throws Exception {
    Endpoint listen = addrStringToEndpoint(
      System.getenv(Constants.kConcordEnvKeyClientListenAddr));
    Endpoint proxy = addrStringToEndpoint(
      System.getenv(Constants.kConcordEnvKeyClientProxyAddr));

    if (listen == null || proxy == null) {
      throw new Exception("Proxy and/or listen addr is misconfigured");
    }
    ThriftService tserver = new ThriftService(c, listen, proxy);
    tserver.serve();
  }

}
