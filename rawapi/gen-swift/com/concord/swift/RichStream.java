package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("RichStream")
public final class RichStream
{
    @ThriftConstructor
    public RichStream(
        @ThriftField(value=1, name="stream", requiredness=Requiredness.NONE) final StreamMetadata stream,
        @ThriftField(value=2, name="computationName", requiredness=Requiredness.NONE) final String computationName,
        @ThriftField(value=3, name="endpoints", requiredness=Requiredness.NONE) final List<Endpoint> endpoints
    ) {
        this.stream = stream;
        this.computationName = computationName;
        this.endpoints = endpoints;
    }

    public static class Builder {
        private StreamMetadata stream;

        public Builder setStream(StreamMetadata stream) {
            this.stream = stream;
            return this;
        }
        private String computationName;

        public Builder setComputationName(String computationName) {
            this.computationName = computationName;
            return this;
        }
        private List<Endpoint> endpoints;

        public Builder setEndpoints(List<Endpoint> endpoints) {
            this.endpoints = endpoints;
            return this;
        }

        public Builder() { }
        public Builder(RichStream other) {
            this.stream = other.stream;
            this.computationName = other.computationName;
            this.endpoints = other.endpoints;
        }

        public RichStream build() {
            return new RichStream (
                this.stream,
                this.computationName,
                this.endpoints
            );
        }
    }

    private final StreamMetadata stream;

    @ThriftField(value=1, name="stream", requiredness=Requiredness.NONE)
    public StreamMetadata getStream() { return stream; }

    private final String computationName;

    @ThriftField(value=2, name="computationName", requiredness=Requiredness.NONE)
    public String getComputationName() { return computationName; }

    private final List<Endpoint> endpoints;

    @ThriftField(value=3, name="endpoints", requiredness=Requiredness.NONE)
    public List<Endpoint> getEndpoints() { return endpoints; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("stream", stream)
            .add("computationName", computationName)
            .add("endpoints", endpoints)
            .toString();
    }
}
