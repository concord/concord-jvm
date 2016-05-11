package io.concord;

import io.concord.Computation;
import io.concord.swift.ComputationService;
import io.concord.swift.Constants;
import io.concord.swift.Endpoint;
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
    this.server = new ThriftServer(processor, serverConfig);
  }

  public void serve() { this.server.start(); }
  public void stop() { this.server.close(); }
}
