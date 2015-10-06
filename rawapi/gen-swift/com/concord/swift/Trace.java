package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("Trace")
public final class Trace
{
    @ThriftConstructor
    public Trace(
        @ThriftField(value=1, name="id", requiredness=Requiredness.NONE) final long id,
        @ThriftField(value=2, name="spans", requiredness=Requiredness.NONE) final List<Span> spans
    ) {
        this.id = id;
        this.spans = spans;
    }

    public static class Builder {
        private long id;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }
        private List<Span> spans;

        public Builder setSpans(List<Span> spans) {
            this.spans = spans;
            return this;
        }

        public Builder() { }
        public Builder(Trace other) {
            this.id = other.id;
            this.spans = other.spans;
        }

        public Trace build() {
            return new Trace (
                this.id,
                this.spans
            );
        }
    }

    private final long id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public long getId() { return id; }

    private final List<Span> spans;

    @ThriftField(value=2, name="spans", requiredness=Requiredness.NONE)
    public List<Span> getSpans() { return spans; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("spans", spans)
            .toString();
    }
}
