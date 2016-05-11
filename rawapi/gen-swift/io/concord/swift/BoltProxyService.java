package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("BoltProxyService")
public interface BoltProxyService extends io.concord.swift.MutableEphemeralStateService, Closeable
{
    @ThriftService("BoltProxyService")
    public interface Async extends Closeable, io.concord.swift.MutableEphemeralStateService.Async
    {
        void close();

        @ThriftMethod(value = "updateTopology",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> updateTopology(
            @ThriftField(value=1, name="topology", requiredness=Requiredness.NONE) final TopologyMetadata topology
        );

        @ThriftMethod(value = "updateSchedulerAddress",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> updateSchedulerAddress(
            @ThriftField(value=1, name="e", requiredness=Requiredness.NONE) final Endpoint e
        );

        @ThriftMethod(value = "registerWithScheduler",
                      oneway = true)
        ListenableFuture<Void> registerWithScheduler(
            @ThriftField(value=1, name="meta", requiredness=Requiredness.NONE) final ComputationMetadata meta
        );
    }
    void close();


    @ThriftMethod(value = "updateTopology",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void updateTopology(
        @ThriftField(value=1, name="topology", requiredness=Requiredness.NONE) final TopologyMetadata topology
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "updateSchedulerAddress",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void updateSchedulerAddress(
        @ThriftField(value=1, name="e", requiredness=Requiredness.NONE) final Endpoint e
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "registerWithScheduler",
                  oneway = true)
    void registerWithScheduler(
        @ThriftField(value=1, name="meta", requiredness=Requiredness.NONE) final ComputationMetadata meta
    ) throws org.apache.thrift.TException;
}