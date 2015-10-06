package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("BoltManagerService")
public interface BoltManagerService extends Closeable
{
    @ThriftService("BoltManagerService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "setEnvironmentVar",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> setEnvironmentVar(
            @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
            @ThriftField(value=2, name="value", requiredness=Requiredness.NONE) final String value
        );

        @ThriftMethod(value = "signal",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> signal(
            @ThriftField(value=1, name="topologyId", requiredness=Requiredness.NONE) final long topologyId,
            @ThriftField(value=2, name="s", requiredness=Requiredness.NONE) final Signal s
        );
    }
    void close();


    @ThriftMethod(value = "setEnvironmentVar",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void setEnvironmentVar(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="value", requiredness=Requiredness.NONE) final String value
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "signal",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void signal(
        @ThriftField(value=1, name="topologyId", requiredness=Requiredness.NONE) final long topologyId,
        @ThriftField(value=2, name="s", requiredness=Requiredness.NONE) final Signal s
    ) throws BoltError, org.apache.thrift.TException;
}