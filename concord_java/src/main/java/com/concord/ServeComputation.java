package com.concord;

import com.concord.Computation;
import com.concord.ThriftService;
import com.concord.swift.Endpoint;
import com.concord.swift.Constants;
import com.google.common.base.Verify;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.UncaughtExceptionHandlers;
import java.util.*;

/**
 * `ServeComputation`
 *
 * Entry point for launching a computation in concord
 * Create your own concrete subclass of `Computation` implementing
 * the abstract methods, and pass an instance to `ServeComputation.serve`.
 */
public class ServeComputation {

  private static Endpoint addrStringToEndpoint(String address) {
    Preconditions.checkNotNull(address);
    final String[] contents = address.split(":", 2);
    Verify.verify(contents.length == 2, "Cannot get ip:port for listen addr");

    return new Endpoint.Builder()
        .setIp(contents[0])
        .setPort(Short.parseShort(contents[1]))
        .build();
  }

  /**
   * 2 Very important things users would care when using this method:
   *    1. It will exit(1) on uncaught exceptions.
   *    2. Sets the same strategy on the class Thread for all threads.
   *
   * It also is a very handy method for serving your computation.
   */
  public static void serve(Computation c) {
    Preconditions.checkNotNull(c);
    // The guava exception handlers will exit on a Throwable
    // not caught, we don't have to catch Throwable's at the api
    Thread.currentThread().setUncaughtExceptionHandler(
        UncaughtExceptionHandlers.systemExit());
    Thread.setDefaultUncaughtExceptionHandler(
        UncaughtExceptionHandlers.systemExit());
    Endpoint listen = addrStringToEndpoint(
        System.getenv(Constants.kConcordEnvKeyClientListenAddr));
    Endpoint proxy = addrStringToEndpoint(
        System.getenv(Constants.kConcordEnvKeyClientProxyAddr));

    ThriftService tserver = new ThriftService(c, listen, proxy);
    tserver.serve();
  }
}
