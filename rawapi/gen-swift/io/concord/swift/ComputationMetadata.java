package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("ComputationMetadata")
public final class ComputationMetadata
{
    @ThriftConstructor
    public ComputationMetadata(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="taskId", requiredness=Requiredness.NONE) final String taskId,
        @ThriftField(value=3, name="istreams", requiredness=Requiredness.NONE) final List<StreamMetadata> istreams,
        @ThriftField(value=4, name="ostreams", requiredness=Requiredness.NONE) final List<String> ostreams,
        @ThriftField(value=5, name="proxyEndpoint", requiredness=Requiredness.NONE) final Endpoint proxyEndpoint
    ) {
        this.name = name;
        this.taskId = taskId;
        this.istreams = istreams;
        this.ostreams = ostreams;
        this.proxyEndpoint = proxyEndpoint;
    }

    public static class Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        private String taskId;

        public Builder setTaskId(String taskId) {
            this.taskId = taskId;
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
        private Endpoint proxyEndpoint;

        public Builder setProxyEndpoint(Endpoint proxyEndpoint) {
            this.proxyEndpoint = proxyEndpoint;
            return this;
        }

        public Builder() { }
        public Builder(ComputationMetadata other) {
            this.name = other.name;
            this.taskId = other.taskId;
            this.istreams = other.istreams;
            this.ostreams = other.ostreams;
            this.proxyEndpoint = other.proxyEndpoint;
        }

        public ComputationMetadata build() {
            return new ComputationMetadata (
                this.name,
                this.taskId,
                this.istreams,
                this.ostreams,
                this.proxyEndpoint
            );
        }
    }

    private final String name;

    @ThriftField(value=1, name="name", requiredness=Requiredness.NONE)
    public String getName() { return name; }

    private final String taskId;

    @ThriftField(value=2, name="taskId", requiredness=Requiredness.NONE)
    public String getTaskId() { return taskId; }

    private final List<StreamMetadata> istreams;

    @ThriftField(value=3, name="istreams", requiredness=Requiredness.NONE)
    public List<StreamMetadata> getIstreams() { return istreams; }

    private final List<String> ostreams;

    @ThriftField(value=4, name="ostreams", requiredness=Requiredness.NONE)
    public List<String> getOstreams() { return ostreams; }

    private final Endpoint proxyEndpoint;

    @ThriftField(value=5, name="proxyEndpoint", requiredness=Requiredness.NONE)
    public Endpoint getProxyEndpoint() { return proxyEndpoint; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("name", name)
            .add("taskId", taskId)
            .add("istreams", istreams)
            .add("ostreams", ostreams)
            .add("proxyEndpoint", proxyEndpoint)
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

        ComputationMetadata other = (ComputationMetadata)o;

        return
            Objects.equals(name, other.name) &&
            Objects.equals(taskId, other.taskId) &&
            Objects.equals(istreams, other.istreams) &&
            Objects.equals(ostreams, other.ostreams) &&
            Objects.equals(proxyEndpoint, other.proxyEndpoint);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            name,
            taskId,
            istreams,
            ostreams,
            proxyEndpoint
        });
    }
}
