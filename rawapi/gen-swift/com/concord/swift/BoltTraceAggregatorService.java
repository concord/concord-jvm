package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("BoltTraceAggregatorService")
public interface BoltTraceAggregatorService extends Closeable
{
    @ThriftService("BoltTraceAggregatorService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "submitSpans",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> submitSpans(
            @ThriftField(value=1, name="span", requiredness=Requiredness.NONE) final List<Span> span
        );

        @ThriftMethod(value = "getTrace",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<List<Span>> getTrace(
            @ThriftField(value=1, name="traceId", requiredness=Requiredness.NONE) final long traceId
        );

        @ThriftMethod(value = "getTraceIds",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<List<Long>> getTraceIds(
            @ThriftField(value=1, name="startId", requiredness=Requiredness.NONE) final long startId,
            @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit
        );

        @ThriftMethod(value = "consolidateTraceIds",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> consolidateTraceIds(
            @ThriftField(value=1, name="traceIds", requiredness=Requiredness.NONE) final List<Long> traceIds
        );
    }
    void close();


    @ThriftMethod(value = "submitSpans",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void submitSpans(
        @ThriftField(value=1, name="span", requiredness=Requiredness.NONE) final List<Span> span
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "getTrace",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    List<Span> getTrace(
        @ThriftField(value=1, name="traceId", requiredness=Requiredness.NONE) final long traceId
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "getTraceIds",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    List<Long> getTraceIds(
        @ThriftField(value=1, name="startId", requiredness=Requiredness.NONE) final long startId,
        @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit
    ) throws BoltError, org.apache.thrift.TException;

    @ThriftMethod(value = "consolidateTraceIds",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void consolidateTraceIds(
        @ThriftField(value=1, name="traceIds", requiredness=Requiredness.NONE) final List<Long> traceIds
    ) throws BoltError, org.apache.thrift.TException;
}