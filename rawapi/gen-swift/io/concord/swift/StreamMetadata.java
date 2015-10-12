package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("StreamMetadata")
public final class StreamMetadata
{
    @ThriftConstructor
    public StreamMetadata(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="grouping", requiredness=Requiredness.NONE) final StreamGrouping grouping
    ) {
        this.name = name;
        this.grouping = grouping;
    }

    public static class Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        private StreamGrouping grouping;

        public Builder setGrouping(StreamGrouping grouping) {
            this.grouping = grouping;
            return this;
        }

        public Builder() { }
        public Builder(StreamMetadata other) {
            this.name = other.name;
            this.grouping = other.grouping;
        }

        public StreamMetadata build() {
            return new StreamMetadata (
                this.name,
                this.grouping
            );
        }
    }

    private final String name;

    @ThriftField(value=1, name="name", requiredness=Requiredness.NONE)
    public String getName() { return name; }

    private final StreamGrouping grouping;

    @ThriftField(value=2, name="grouping", requiredness=Requiredness.NONE)
    public StreamGrouping getGrouping() { return grouping; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("name", name)
            .add("grouping", grouping)
            .toString();
    }
}
