package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

@ThriftStruct("BoltError")
public final class BoltError extends Exception
{
    private static final long serialVersionUID = 1L;

    @ThriftConstructor
    public BoltError(
        @ThriftField(value=1, name="reason", requiredness=Requiredness.NONE) final String reason,
        @ThriftField(value=2, name="context", requiredness=Requiredness.NONE) final String context,
        @ThriftField(value=3, name="time", requiredness=Requiredness.NONE) final long time
    ) {
        this.reason = reason;
        this.context = context;
        this.time = time;
    }

    public static class Builder {
        private String reason;

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }
        private String context;

        public Builder setContext(String context) {
            this.context = context;
            return this;
        }
        private long time;

        public Builder setTime(long time) {
            this.time = time;
            return this;
        }

        public Builder() { }
        public Builder(BoltError other) {
            this.reason = other.reason;
            this.context = other.context;
            this.time = other.time;
        }

        public BoltError build() {
            return new BoltError (
                this.reason,
                this.context,
                this.time
            );
        }
    }

    private final String reason;

    @ThriftField(value=1, name="reason", requiredness=Requiredness.NONE)
    public String getReason() { return reason; }

    private final String context;

    @ThriftField(value=2, name="context", requiredness=Requiredness.NONE)
    public String getContext() { return context; }

    private final long time;

    @ThriftField(value=3, name="time", requiredness=Requiredness.NONE)
    public long getTime() { return time; }
}
