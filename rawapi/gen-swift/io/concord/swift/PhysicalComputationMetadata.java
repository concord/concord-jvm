package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("PhysicalComputationMetadata")
public final class PhysicalComputationMetadata
{
    @ThriftConstructor
    public PhysicalComputationMetadata(
        @ThriftField(value=1, name="taskId", requiredness=Requiredness.NONE) final String taskId,
        @ThriftField(value=2, name="slaveId", requiredness=Requiredness.NONE) final String slaveId,
        @ThriftField(value=3, name="cpus", requiredness=Requiredness.NONE) final double cpus,
        @ThriftField(value=4, name="mem", requiredness=Requiredness.NONE) final double mem,
        @ThriftField(value=5, name="disk", requiredness=Requiredness.NONE) final double disk,
        @ThriftField(value=6, name="taskHelper", requiredness=Requiredness.NONE) final ExecutorTaskInfoHelper taskHelper,
        @ThriftField(value=7, name="needsReconciliation", requiredness=Requiredness.NONE) final boolean needsReconciliation,
        @ThriftField(value=8, name="killed", requiredness=Requiredness.NONE) final boolean killed,
        @ThriftField(value=9, name="gpus", requiredness=Requiredness.NONE) final double gpus
    ) {
        this.taskId = taskId;
        this.slaveId = slaveId;
        this.cpus = cpus;
        this.mem = mem;
        this.disk = disk;
        this.taskHelper = taskHelper;
        this.needsReconciliation = needsReconciliation;
        this.killed = killed;
        this.gpus = gpus;
    }

    public static class Builder {
        private String taskId;

        public Builder setTaskId(String taskId) {
            this.taskId = taskId;
            return this;
        }
        private String slaveId;

        public Builder setSlaveId(String slaveId) {
            this.slaveId = slaveId;
            return this;
        }
        private double cpus;

        public Builder setCpus(double cpus) {
            this.cpus = cpus;
            return this;
        }
        private double mem;

        public Builder setMem(double mem) {
            this.mem = mem;
            return this;
        }
        private double disk;

        public Builder setDisk(double disk) {
            this.disk = disk;
            return this;
        }
        private ExecutorTaskInfoHelper taskHelper;

        public Builder setTaskHelper(ExecutorTaskInfoHelper taskHelper) {
            this.taskHelper = taskHelper;
            return this;
        }
        private boolean needsReconciliation;

        public Builder setNeedsReconciliation(boolean needsReconciliation) {
            this.needsReconciliation = needsReconciliation;
            return this;
        }
        private boolean killed;

        public Builder setKilled(boolean killed) {
            this.killed = killed;
            return this;
        }
        private double gpus;

        public Builder setGpus(double gpus) {
            this.gpus = gpus;
            return this;
        }

        public Builder() { }
        public Builder(PhysicalComputationMetadata other) {
            this.taskId = other.taskId;
            this.slaveId = other.slaveId;
            this.cpus = other.cpus;
            this.mem = other.mem;
            this.disk = other.disk;
            this.taskHelper = other.taskHelper;
            this.needsReconciliation = other.needsReconciliation;
            this.killed = other.killed;
            this.gpus = other.gpus;
        }

        public PhysicalComputationMetadata build() {
            return new PhysicalComputationMetadata (
                this.taskId,
                this.slaveId,
                this.cpus,
                this.mem,
                this.disk,
                this.taskHelper,
                this.needsReconciliation,
                this.killed,
                this.gpus
            );
        }
    }

    private final String taskId;

    @ThriftField(value=1, name="taskId", requiredness=Requiredness.NONE)
    public String getTaskId() { return taskId; }

    private final String slaveId;

    @ThriftField(value=2, name="slaveId", requiredness=Requiredness.NONE)
    public String getSlaveId() { return slaveId; }

    private final double cpus;

    @ThriftField(value=3, name="cpus", requiredness=Requiredness.NONE)
    public double getCpus() { return cpus; }

    private final double mem;

    @ThriftField(value=4, name="mem", requiredness=Requiredness.NONE)
    public double getMem() { return mem; }

    private final double disk;

    @ThriftField(value=5, name="disk", requiredness=Requiredness.NONE)
    public double getDisk() { return disk; }

    private final ExecutorTaskInfoHelper taskHelper;

    @ThriftField(value=6, name="taskHelper", requiredness=Requiredness.NONE)
    public ExecutorTaskInfoHelper getTaskHelper() { return taskHelper; }

    private final boolean needsReconciliation;

    @ThriftField(value=7, name="needsReconciliation", requiredness=Requiredness.NONE)
    public boolean isNeedsReconciliation() { return needsReconciliation; }

    private final boolean killed;

    @ThriftField(value=8, name="killed", requiredness=Requiredness.NONE)
    public boolean isKilled() { return killed; }

    private final double gpus;

    @ThriftField(value=9, name="gpus", requiredness=Requiredness.NONE)
    public double getGpus() { return gpus; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("taskId", taskId)
            .add("slaveId", slaveId)
            .add("cpus", cpus)
            .add("mem", mem)
            .add("disk", disk)
            .add("taskHelper", taskHelper)
            .add("needsReconciliation", needsReconciliation)
            .add("killed", killed)
            .add("gpus", gpus)
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

        PhysicalComputationMetadata other = (PhysicalComputationMetadata)o;

        return
            Objects.equals(taskId, other.taskId) &&
            Objects.equals(slaveId, other.slaveId) &&
            Objects.equals(cpus, other.cpus) &&
            Objects.equals(mem, other.mem) &&
            Objects.equals(disk, other.disk) &&
            Objects.equals(taskHelper, other.taskHelper) &&
            Objects.equals(needsReconciliation, other.needsReconciliation) &&
            Objects.equals(killed, other.killed) &&
            Objects.equals(gpus, other.gpus);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            taskId,
            slaveId,
            cpus,
            mem,
            disk,
            taskHelper,
            needsReconciliation,
            killed,
            gpus
        });
    }
}
