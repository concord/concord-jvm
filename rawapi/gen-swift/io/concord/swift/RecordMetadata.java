package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("RecordMetadata")
public final class RecordMetadata
{
    @ThriftConstructor
    public RecordMetadata(
        @ThriftField(value=1, name="traceId", requiredness=Requiredness.NONE) final long traceId,
        @ThriftField(value=2, name="sourceSpanId", requiredness=Requiredness.NONE) final long sourceSpanId,
        @ThriftField(value=3, name="flags", requiredness=Requiredness.NONE) final int flags,
        @ThriftField(value=4, name="stream", requiredness=Requiredness.NONE) final long stream,
        @ThriftField(value=5, name="timestamp", requiredness=Requiredness.NONE) final long timestamp
    ) {
        this.traceId = traceId;
        this.sourceSpanId = sourceSpanId;
        this.flags = flags;
        this.stream = stream;
        this.timestamp = timestamp;
    }

    public static class Builder {
        private long traceId;

        public Builder setTraceId(long traceId) {
            this.traceId = traceId;
            return this;
        }
        private long sourceSpanId;

        public Builder setSourceSpanId(long sourceSpanId) {
            this.sourceSpanId = sourceSpanId;
            return this;
        }
        private int flags;

        public Builder setFlags(int flags) {
            this.flags = flags;
            return this;
        }
        private long stream;

        public Builder setStream(long stream) {
            this.stream = stream;
            return this;
        }
        private long timestamp;

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder() { }
        public Builder(RecordMetadata other) {
            this.traceId = other.traceId;
            this.sourceSpanId = other.sourceSpanId;
            this.flags = other.flags;
            this.stream = other.stream;
            this.timestamp = other.timestamp;
        }

        public RecordMetadata build() {
            return new RecordMetadata (
                this.traceId,
                this.sourceSpanId,
                this.flags,
                this.stream,
                this.timestamp
            );
        }
    }

    private final long traceId;

    @ThriftField(value=1, name="traceId", requiredness=Requiredness.NONE)
    public long getTraceId() { return traceId; }

    private final long sourceSpanId;

    @ThriftField(value=2, name="sourceSpanId", requiredness=Requiredness.NONE)
    public long getSourceSpanId() { return sourceSpanId; }

    private final int flags;

    @ThriftField(value=3, name="flags", requiredness=Requiredness.NONE)
    public int getFlags() { return flags; }

    private final long stream;

    @ThriftField(value=4, name="stream", requiredness=Requiredness.NONE)
    public long getStream() { return stream; }

    private final long timestamp;

    @ThriftField(value=5, name="timestamp", requiredness=Requiredness.NONE)
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("traceId", traceId)
            .add("sourceSpanId", sourceSpanId)
            .add("flags", flags)
            .add("stream", stream)
            .add("timestamp", timestamp)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RecordMetadata other = (RecordMetadata)o;

        return
            Objects.equals(traceId, other.traceId) &&
            Objects.equals(sourceSpanId, other.sourceSpanId) &&
            Objects.equals(flags, other.flags) &&
            Objects.equals(stream, other.stream) &&
            Objects.equals(timestamp, other.timestamp);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            traceId,
            sourceSpanId,
            flags,
            stream,
            timestamp
        });
    }
}
