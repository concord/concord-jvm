package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("BoltMetricsService")
public interface BoltMetricsService extends Closeable
{
    @ThriftService("BoltMetricsService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "gauge",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> gauge(
            @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
            @ThriftField(value=2, name="val", requiredness=Requiredness.NONE) final long val
        );

        @ThriftMethod(value = "timer",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> timer(
            @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
            @ThriftField(value=2, name="duration", requiredness=Requiredness.NONE) final long duration
        );

        @ThriftMethod(value = "histogram",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> histogram(
            @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
            @ThriftField(value=2, name="measure", requiredness=Requiredness.NONE) final long measure
        );

        @ThriftMethod(value = "sum",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> sum(
            @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
            @ThriftField(value=2, name="counter", requiredness=Requiredness.NONE) final long counter
        );
    }
    void close();


    @ThriftMethod(value = "gauge",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void gauge(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="val", requiredness=Requiredness.NONE) final long val
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "timer",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void timer(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="duration", requiredness=Requiredness.NONE) final long duration
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "histogram",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void histogram(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="measure", requiredness=Requiredness.NONE) final long measure
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "sum",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void sum(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="counter", requiredness=Requiredness.NONE) final long counter
    ) throws BoltError, org.apache.thrift.TException;
}