package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("SchedulerMetadata")
public final class SchedulerMetadata
{
    @ThriftConstructor
    public SchedulerMetadata(
        @ThriftField(value=1, name="endpoint", requiredness=Requiredness.NONE) final Endpoint endpoint,
        @ThriftField(value=2, name="version", requiredness=Requiredness.NONE) final int version
    ) {
        this.endpoint = endpoint;
        this.version = version;
    }

    public static class Builder {
        private Endpoint endpoint;

        public Builder setEndpoint(Endpoint endpoint) {
            this.endpoint = endpoint;
            return this;
        }
        private int version;

        public Builder setVersion(int version) {
            this.version = version;
            return this;
        }

        public Builder() { }
        public Builder(SchedulerMetadata other) {
            this.endpoint = other.endpoint;
            this.version = other.version;
        }

        public SchedulerMetadata build() {
            return new SchedulerMetadata (
                this.endpoint,
                this.version
            );
        }
    }

    private final Endpoint endpoint;

    @ThriftField(value=1, name="endpoint", requiredness=Requiredness.NONE)
    public Endpoint getEndpoint() { return endpoint; }

    private final int version;

    @ThriftField(value=2, name="version", requiredness=Requiredness.NONE)
    public int getVersion() { return version; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("endpoint", endpoint)
            .add("version", version)
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

        SchedulerMetadata other = (SchedulerMetadata)o;

        return
            Objects.equals(endpoint, other.endpoint) &&
            Objects.equals(version, other.version);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            endpoint,
            version
        });
    }
}
