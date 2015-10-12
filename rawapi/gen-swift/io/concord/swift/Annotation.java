package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("Annotation")
public final class Annotation
{
    @ThriftConstructor
    public Annotation(
        @ThriftField(value=1, name="timestamp", requiredness=Requiredness.NONE) final long timestamp,
        @ThriftField(value=2, name="type", requiredness=Requiredness.NONE) final AnnotationType type,
        @ThriftField(value=3, name="key", requiredness=Requiredness.NONE) final String key,
        @ThriftField(value=4, name="value", requiredness=Requiredness.NONE) final byte [] value,
        @ThriftField(value=5, name="host", requiredness=Requiredness.NONE) final Endpoint host
    ) {
        this.timestamp = timestamp;
        this.type = type;
        this.key = key;
        this.value = value;
        this.host = host;
    }

    public static class Builder {
        private long timestamp;

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }
        private AnnotationType type;

        public Builder setType(AnnotationType type) {
            this.type = type;
            return this;
        }
        private String key;

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }
        private byte [] value;

        public Builder setValue(byte [] value) {
            this.value = value;
            return this;
        }
        private Endpoint host;

        public Builder setHost(Endpoint host) {
            this.host = host;
            return this;
        }

        public Builder() { }
        public Builder(Annotation other) {
            this.timestamp = other.timestamp;
            this.type = other.type;
            this.key = other.key;
            this.value = other.value;
            this.host = other.host;
        }

        public Annotation build() {
            return new Annotation (
                this.timestamp,
                this.type,
                this.key,
                this.value,
                this.host
            );
        }
    }

    private final long timestamp;

    @ThriftField(value=1, name="timestamp", requiredness=Requiredness.NONE)
    public long getTimestamp() { return timestamp; }

    private final AnnotationType type;

    @ThriftField(value=2, name="type", requiredness=Requiredness.NONE)
    public AnnotationType getType() { return type; }

    private final String key;

    @ThriftField(value=3, name="key", requiredness=Requiredness.NONE)
    public String getKey() { return key; }

    private final byte [] value;

    @ThriftField(value=4, name="value", requiredness=Requiredness.NONE)
    public byte [] getValue() { return value; }

    private final Endpoint host;

    @ThriftField(value=5, name="host", requiredness=Requiredness.NONE)
    public Endpoint getHost() { return host; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("timestamp", timestamp)
            .add("type", type)
            .add("key", key)
            .add("value", value)
            .add("host", host)
            .toString();
    }
}
