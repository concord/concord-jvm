package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("PhysicalComputationLayout")
public final class PhysicalComputationLayout
{
    @ThriftConstructor
    public PhysicalComputationLayout(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="istreams", requiredness=Requiredness.NONE) final List<StreamMetadata> istreams,
        @ThriftField(value=3, name="ostreams", requiredness=Requiredness.NONE) final List<String> ostreams,
        @ThriftField(value=4, name="nodes", requiredness=Requiredness.NONE) final List<PhysicalComputationMetadata> nodes
    ) {
        this.name = name;
        this.istreams = istreams;
        this.ostreams = ostreams;
        this.nodes = nodes;
    }

    public static class Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        private List<StreamMetadata> istreams;

        public Builder setIstreams(List<StreamMetadata> istreams) {
            this.istreams = istreams;
            return this;
        }
        private List<String> ostreams;

        public Builder setOstreams(List<String> ostreams) {
            this.ostreams = ostreams;
            return this;
        }
        private List<PhysicalComputationMetadata> nodes;

        public Builder setNodes(List<PhysicalComputationMetadata> nodes) {
            this.nodes = nodes;
            return this;
        }

        public Builder() { }
        public Builder(PhysicalComputationLayout other) {
            this.name = other.name;
            this.istreams = other.istreams;
            this.ostreams = other.ostreams;
            this.nodes = other.nodes;
        }

        public PhysicalComputationLayout build() {
            return new PhysicalComputationLayout (
                this.name,
                this.istreams,
                this.ostreams,
                this.nodes
            );
        }
    }

    private final String name;

    @ThriftField(value=1, name="name", requiredness=Requiredness.NONE)
    public String getName() { return name; }

    private final List<StreamMetadata> istreams;

    @ThriftField(value=2, name="istreams", requiredness=Requiredness.NONE)
    public List<StreamMetadata> getIstreams() { return istreams; }

    private final List<String> ostreams;

    @ThriftField(value=3, name="ostreams", requiredness=Requiredness.NONE)
    public List<String> getOstreams() { return ostreams; }

    private final List<PhysicalComputationMetadata> nodes;

    @ThriftField(value=4, name="nodes", requiredness=Requiredness.NONE)
    public List<PhysicalComputationMetadata> getNodes() { return nodes; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("name", name)
            .add("istreams", istreams)
            .add("ostreams", ostreams)
            .add("nodes", nodes)
            .toString();
    }
}
