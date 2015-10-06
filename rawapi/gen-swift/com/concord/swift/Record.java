package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("Record")
public final class Record
{
    @ThriftConstructor
    public Record(
        @ThriftField(value=1, name="meta", requiredness=Requiredness.NONE) final RecordMetadata meta,
        @ThriftField(value=2, name="time", requiredness=Requiredness.NONE) final long time,
        @ThriftField(value=3, name="key", requiredness=Requiredness.NONE) final byte [] key,
        @ThriftField(value=4, name="data", requiredness=Requiredness.NONE) final byte [] data,
        @ThriftField(value=5, name="userStream", requiredness=Requiredness.NONE) final byte [] userStream
    ) {
        this.meta = meta;
        this.time = time;
        this.key = key;
        this.data = data;
        this.userStream = userStream;
    }

    public static class Builder {
        private RecordMetadata meta;

        public Builder setMeta(RecordMetadata meta) {
            this.meta = meta;
            return this;
        }
        private long time;

        public Builder setTime(long time) {
            this.time = time;
            return this;
        }
        private byte [] key;

        public Builder setKey(byte [] key) {
            this.key = key;
            return this;
        }
        private byte [] data;

        public Builder setData(byte [] data) {
            this.data = data;
            return this;
        }
        private byte [] userStream;

        public Builder setUserStream(byte [] userStream) {
            this.userStream = userStream;
            return this;
        }

        public Builder() { }
        public Builder(Record other) {
            this.meta = other.meta;
            this.time = other.time;
            this.key = other.key;
            this.data = other.data;
            this.userStream = other.userStream;
        }

        public Record build() {
            return new Record (
                this.meta,
                this.time,
                this.key,
                this.data,
                this.userStream
            );
        }
    }

    private final RecordMetadata meta;

    @ThriftField(value=1, name="meta", requiredness=Requiredness.NONE)
    public RecordMetadata getMeta() { return meta; }

    private final long time;

    @ThriftField(value=2, name="time", requiredness=Requiredness.NONE)
    public long getTime() { return time; }

    private final byte [] key;

    @ThriftField(value=3, name="key", requiredness=Requiredness.NONE)
    public byte [] getKey() { return key; }

    private final byte [] data;

    @ThriftField(value=4, name="data", requiredness=Requiredness.NONE)
    public byte [] getData() { return data; }

    private final byte [] userStream;

    @ThriftField(value=5, name="userStream", requiredness=Requiredness.NONE)
    public byte [] getUserStream() { return userStream; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("meta", meta)
            .add("time", time)
            .add("key", key)
            .add("data", data)
            .add("userStream", userStream)
            .toString();
    }
}
