package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("Span")
public final class Span
{
    @ThriftConstructor
    public Span(
        @ThriftField(value=1, name="traceId", requiredness=Requiredness.NONE) final long traceId,
        @ThriftField(value=2, name="id", requiredness=Requiredness.NONE) final long id,
        @ThriftField(value=3, name="parentId", requiredness=Requiredness.NONE) final long parentId,
        @ThriftField(value=4, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=5, name="annotations", requiredness=Requiredness.NONE) final List<Annotation> annotations
    ) {
        this.traceId = traceId;
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.annotations = annotations;
    }

    public static class Builder {
        private long traceId;

        public Builder setTraceId(long traceId) {
            this.traceId = traceId;
            return this;
        }
        private long id;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }
        private long parentId;

        public Builder setParentId(long parentId) {
            this.parentId = parentId;
            return this;
        }
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        private List<Annotation> annotations;

        public Builder setAnnotations(List<Annotation> annotations) {
            this.annotations = annotations;
            return this;
        }

        public Builder() { }
        public Builder(Span other) {
            this.traceId = other.traceId;
            this.id = other.id;
            this.parentId = other.parentId;
            this.name = other.name;
            this.annotations = other.annotations;
        }

        public Span build() {
            return new Span (
                this.traceId,
                this.id,
                this.parentId,
                this.name,
                this.annotations
            );
        }
    }

    private final long traceId;

    @ThriftField(value=1, name="traceId", requiredness=Requiredness.NONE)
    public long getTraceId() { return traceId; }

    private final long id;

    @ThriftField(value=2, name="id", requiredness=Requiredness.NONE)
    public long getId() { return id; }

    private final long parentId;

    @ThriftField(value=3, name="parentId", requiredness=Requiredness.NONE)
    public long getParentId() { return parentId; }

    private final String name;

    @ThriftField(value=4, name="name", requiredness=Requiredness.NONE)
    public String getName() { return name; }

    private final List<Annotation> annotations;

    @ThriftField(value=5, name="annotations", requiredness=Requiredness.NONE)
    public List<Annotation> getAnnotations() { return annotations; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("traceId", traceId)
            .add("id", id)
            .add("parentId", parentId)
            .add("name", name)
            .add("annotations", annotations)
            .toString();
    }
}
