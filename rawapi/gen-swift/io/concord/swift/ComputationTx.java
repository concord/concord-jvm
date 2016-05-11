package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("ComputationTx")
public final class ComputationTx
{
    @ThriftConstructor
    public ComputationTx(
        @ThriftField(value=1, name="id", requiredness=Requiredness.NONE) final long id,
        @ThriftField(value=2, name="records", requiredness=Requiredness.NONE) final List<Record> records,
        @ThriftField(value=3, name="timers", requiredness=Requiredness.NONE) final Map<String, Long> timers
    ) {
        this.id = id;
        this.records = records;
        this.timers = timers;
    }

    public static class Builder {
        private long id;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }
        private List<Record> records;

        public Builder setRecords(List<Record> records) {
            this.records = records;
            return this;
        }
        private Map<String, Long> timers;

        public Builder setTimers(Map<String, Long> timers) {
            this.timers = timers;
            return this;
        }

        public Builder() { }
        public Builder(ComputationTx other) {
            this.id = other.id;
            this.records = other.records;
            this.timers = other.timers;
        }

        public ComputationTx build() {
            return new ComputationTx (
                this.id,
                this.records,
                this.timers
            );
        }
    }

    private final long id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public long getId() { return id; }

    private final List<Record> records;

    @ThriftField(value=2, name="records", requiredness=Requiredness.NONE)
    public List<Record> getRecords() { return records; }

    private final Map<String, Long> timers;

    @ThriftField(value=3, name="timers", requiredness=Requiredness.NONE)
    public Map<String, Long> getTimers() { return timers; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("records", records)
            .add("timers", timers)
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

        ComputationTx other = (ComputationTx)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(records, other.records) &&
            Objects.equals(timers, other.timers);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            records,
            timers
        });
    }
}
