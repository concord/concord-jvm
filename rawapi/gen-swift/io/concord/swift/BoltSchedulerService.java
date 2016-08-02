package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("BoltSchedulerService")
public interface BoltSchedulerService extends Closeable
{
    @ThriftService("BoltSchedulerService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "deployComputation",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> deployComputation(
            @ThriftField(value=1, name="request", requiredness=Requiredness.NONE) final BoltComputationRequest request
        );

        @ThriftMethod(value = "getComputationSlug",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<byte[]> getComputationSlug(
            @ThriftField(value=1, name="computationName", requiredness=Requiredness.NONE) final String computationName
        );

        @ThriftMethod(value = "registerComputation",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<TopologyMetadata> registerComputation(
            @ThriftField(value=1, name="computation", requiredness=Requiredness.NONE) final ComputationMetadata computation
        );

        @ThriftMethod(value = "killTask",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> killTask(
            @ThriftField(value=1, name="taskId", requiredness=Requiredness.NONE) final String taskId
        );
    }
    void close();


    @ThriftMethod(value = "deployComputation",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void deployComputation(
        @ThriftField(value=1, name="request", requiredness=Requiredness.NONE) final BoltComputationRequest request
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "getComputationSlug",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    byte[] getComputationSlug(
        @ThriftField(value=1, name="computationName", requiredness=Requiredness.NONE) final String computationName
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "registerComputation",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    TopologyMetadata registerComputation(
        @ThriftField(value=1, name="computation", requiredness=Requiredness.NONE) final ComputationMetadata computation
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "killTask",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void killTask(
        @ThriftField(value=1, name="taskId", requiredness=Requiredness.NONE) final String taskId
    ) throws BoltError, org.apache.thrift.TException;
}