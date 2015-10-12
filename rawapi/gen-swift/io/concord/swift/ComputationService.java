package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("ComputationService")
public interface ComputationService extends Closeable
{
    @ThriftService("ComputationService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "init",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<ComputationTx> init();

        @ThriftMethod(value = "boltProcessRecords",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<List<ComputationTx>> boltProcessRecords(
            @ThriftField(value=1, name="records", requiredness=Requiredness.NONE) final List<Record> records
        );

        @ThriftMethod(value = "boltProcessTimer",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<ComputationTx> boltProcessTimer(
            @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key,
            @ThriftField(value=2, name="time", requiredness=Requiredness.NONE) final long time
        );

        @ThriftMethod(value = "boltMetadata",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<ComputationMetadata> boltMetadata();
    }
    void close();


    @ThriftMethod(value = "init",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    ComputationTx init() throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "boltProcessRecords",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    List<ComputationTx> boltProcessRecords(
        @ThriftField(value=1, name="records", requiredness=Requiredness.NONE) final List<Record> records
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "boltProcessTimer",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    ComputationTx boltProcessTimer(
        @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key,
        @ThriftField(value=2, name="time", requiredness=Requiredness.NONE) final long time
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "boltMetadata",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    ComputationMetadata boltMetadata() throws BoltError, org.apache.thrift.TException;
}