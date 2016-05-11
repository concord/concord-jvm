package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("BoltPipeService")
public interface BoltPipeService extends Closeable
{
    @ThriftService("BoltPipeService")
    public interface Async extends Closeable
    {
        void close();

        @ThriftMethod(value = "dispatchRecords",
                      exception = {
                          @ThriftException(type=BoltError.class, id=1)
                      })
        ListenableFuture<Void> dispatchRecords(
            @ThriftField(value=1, name="records", requiredness=Requiredness.NONE) final List<Record> records
        );
    }
    void close();


    @ThriftMethod(value = "dispatchRecords",
                  exception = {
                      @ThriftException(type=BoltError.class, id=1)
                  })
    void dispatchRecords(
        @ThriftField(value=1, name="records", requiredness=Requiredness.NONE) final List<Record> records
    ) throws BoltError, org.apache.thrift.TException;
}