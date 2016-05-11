package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("TopologyMetadata")
public final class TopologyMetadata
{
    @ThriftConstructor
    public TopologyMetadata(
        @ThriftField(value=1, name="version", requiredness=Requiredness.NONE) final int version,
        @ThriftField(value=2, name="computations", requiredness=Requiredness.NONE) final Map<String, PhysicalComputationLayout> computations,
        @ThriftField(value=3, name="frameworkID", requiredness=Requiredness.NONE) final String frameworkID,
        @ThriftField(value=4, name="kafkaBrokerList", requiredness=Requiredness.NONE) final String kafkaBrokerList
    ) {
        this.version = version;
        this.computations = computations;
        this.frameworkID = frameworkID;
        this.kafkaBrokerList = kafkaBrokerList;
    }

    public static class Builder {
        private int version;

        public Builder setVersion(int version) {
            this.version = version;
            return this;
        }
        private Map<String, PhysicalComputationLayout> computations;

        public Builder setComputations(Map<String, PhysicalComputationLayout> computations) {
            this.computations = computations;
            return this;
        }
        private String frameworkID;

        public Builder setFrameworkID(String frameworkID) {
            this.frameworkID = frameworkID;
            return this;
        }
        private String kafkaBrokerList;

        public Builder setKafkaBrokerList(String kafkaBrokerList) {
            this.kafkaBrokerList = kafkaBrokerList;
            return this;
        }

        public Builder() { }
        public Builder(TopologyMetadata other) {
            this.version = other.version;
            this.computations = other.computations;
            this.frameworkID = other.frameworkID;
            this.kafkaBrokerList = other.kafkaBrokerList;
        }

        public TopologyMetadata build() {
            return new TopologyMetadata (
                this.version,
                this.computations,
                this.frameworkID,
                this.kafkaBrokerList
            );
        }
    }

    private final int version;

    @ThriftField(value=1, name="version", requiredness=Requiredness.NONE)
    public int getVersion() { return version; }

    private final Map<String, PhysicalComputationLayout> computations;

    @ThriftField(value=2, name="computations", requiredness=Requiredness.NONE)
    public Map<String, PhysicalComputationLayout> getComputations() { return computations; }

    private final String frameworkID;

    @ThriftField(value=3, name="frameworkID", requiredness=Requiredness.NONE)
    public String getFrameworkID() { return frameworkID; }

    private final String kafkaBrokerList;

    @ThriftField(value=4, name="kafkaBrokerList", requiredness=Requiredness.NONE)
    public String getKafkaBrokerList() { return kafkaBrokerList; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("version", version)
            .add("computations", computations)
            .add("frameworkID", frameworkID)
            .add("kafkaBrokerList", kafkaBrokerList)
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

        TopologyMetadata other = (TopologyMetadata)o;

        return
            Objects.equals(version, other.version) &&
            Objects.equals(computations, other.computations) &&
            Objects.equals(frameworkID, other.frameworkID) &&
            Objects.equals(kafkaBrokerList, other.kafkaBrokerList);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            version,
            computations,
            frameworkID,
            kafkaBrokerList
        });
    }
}
