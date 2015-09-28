package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("MutableEphemeralStateService")
public interface MutableEphemeralStateService extends Closeable
{
    @ThriftService("MutableEphemeralStateService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "setState",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> setState(
            @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key,
            @ThriftField(value=2, name="value", requiredness=Requiredness.NONE) final byte [] value
        );

        @ThriftMethod(value = "getState",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<byte []> getState(
            @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key
        );
    }
    void close();


    @ThriftMethod(value = "setState",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void setState(
        @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key,
        @ThriftField(value=2, name="value", requiredness=Requiredness.NONE) final byte [] value
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "getState",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    byte [] getState(
        @ThriftField(value=1, name="key", requiredness=Requiredness.NONE) final String key
    ) throws BoltError, org.apache.thrift.TException;
}