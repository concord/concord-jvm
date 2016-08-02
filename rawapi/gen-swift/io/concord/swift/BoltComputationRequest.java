package io.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("BoltComputationRequest")
public final class BoltComputationRequest
{
    @ThriftConstructor
    public BoltComputationRequest(
        @ThriftField(value=1, name="name", requiredness=Requiredness.NONE) final String name,
        @ThriftField(value=2, name="instances", requiredness=Requiredness.NONE) final long instances,
        @ThriftField(value=3, name="cpus", requiredness=Requiredness.NONE) final double cpus,
        @ThriftField(value=4, name="mem", requiredness=Requiredness.NONE) final long mem,
        @ThriftField(value=5, name="disk", requiredness=Requiredness.NONE) final long disk,
        @ThriftField(value=6, name="taskHelper", requiredness=Requiredness.NONE) final ExecutorTaskInfoHelper taskHelper,
        @ThriftField(value=7, name="forceUpdateBinary", requiredness=Requiredness.NONE) final boolean forceUpdateBinary,
        @ThriftField(value=8, name="slug", requiredness=Requiredness.NONE) final byte[] slug,
        @ThriftField(value=9, name="forcePullContainer", requiredness=Requiredness.NONE) final boolean forcePullContainer,
        @ThriftField(value=10, name="executorArgs", requiredness=Requiredness.NONE) final List<String> executorArgs
    ) {
        this.name = name;
        this.instances = instances;
        this.cpus = cpus;
        this.mem = mem;
        this.disk = disk;
        this.taskHelper = taskHelper;
        this.forceUpdateBinary = forceUpdateBinary;
        this.slug = slug;
        this.forcePullContainer = forcePullContainer;
        this.executorArgs = executorArgs;
    }

    public static class Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        private long instances;

        public Builder setInstances(long instances) {
            this.instances = instances;
            return this;
        }
        private double cpus;

        public Builder setCpus(double cpus) {
            this.cpus = cpus;
            return this;
        }
        private long mem;

        public Builder setMem(long mem) {
            this.mem = mem;
            return this;
        }
        private long disk;

        public Builder setDisk(long disk) {
            this.disk = disk;
            return this;
        }
        private ExecutorTaskInfoHelper taskHelper;

        public Builder setTaskHelper(ExecutorTaskInfoHelper taskHelper) {
            this.taskHelper = taskHelper;
            return this;
        }
        private boolean forceUpdateBinary;

        public Builder setForceUpdateBinary(boolean forceUpdateBinary) {
            this.forceUpdateBinary = forceUpdateBinary;
            return this;
        }
        private byte[] slug;

        public Builder setSlug(byte[] slug) {
            this.slug = slug;
            return this;
        }
        private boolean forcePullContainer;

        public Builder setForcePullContainer(boolean forcePullContainer) {
            this.forcePullContainer = forcePullContainer;
            return this;
        }
        private List<String> executorArgs;

        public Builder setExecutorArgs(List<String> executorArgs) {
            this.executorArgs = executorArgs;
            return this;
        }

        public Builder() { }
        public Builder(BoltComputationRequest other) {
            this.name = other.name;
            this.instances = other.instances;
            this.cpus = other.cpus;
            this.mem = other.mem;
            this.disk = other.disk;
            this.taskHelper = other.taskHelper;
            this.forceUpdateBinary = other.forceUpdateBinary;
            this.slug = other.slug;
            this.forcePullContainer = other.forcePullContainer;
            this.executorArgs = other.executorArgs;
        }

        public BoltComputationRequest build() {
            return new BoltComputationRequest (
                this.name,
                this.instances,
                this.cpus,
                this.mem,
                this.disk,
                this.taskHelper,
                this.forceUpdateBinary,
                this.slug,
                this.forcePullContainer,
                this.executorArgs
            );
        }
    }

    private final String name;

    @ThriftField(value=1, name="name", requiredness=Requiredness.NONE)
    public String getName() { return name; }

    private final long instances;

    @ThriftField(value=2, name="instances", requiredness=Requiredness.NONE)
    public long getInstances() { return instances; }

    private final double cpus;

    @ThriftField(value=3, name="cpus", requiredness=Requiredness.NONE)
    public double getCpus() { return cpus; }

    private final long mem;

    @ThriftField(value=4, name="mem", requiredness=Requiredness.NONE)
    public long getMem() { return mem; }

    private final long disk;

    @ThriftField(value=5, name="disk", requiredness=Requiredness.NONE)
    public long getDisk() { return disk; }

    private final ExecutorTaskInfoHelper taskHelper;

    @ThriftField(value=6, name="taskHelper", requiredness=Requiredness.NONE)
    public ExecutorTaskInfoHelper getTaskHelper() { return taskHelper; }

    private final boolean forceUpdateBinary;

    @ThriftField(value=7, name="forceUpdateBinary", requiredness=Requiredness.NONE)
    public boolean isForceUpdateBinary() { return forceUpdateBinary; }

    private final byte[] slug;

    @ThriftField(value=8, name="slug", requiredness=Requiredness.NONE)
    public byte[] getSlug() { return slug; }

    private final boolean forcePullContainer;

    @ThriftField(value=9, name="forcePullContainer", requiredness=Requiredness.NONE)
    public boolean isForcePullContainer() { return forcePullContainer; }

    private final List<String> executorArgs;

    @ThriftField(value=10, name="executorArgs", requiredness=Requiredness.NONE)
    public List<String> getExecutorArgs() { return executorArgs; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("name", name)
            .add("instances", instances)
            .add("cpus", cpus)
            .add("mem", mem)
            .add("disk", disk)
            .add("taskHelper", taskHelper)
            .add("forceUpdateBinary", forceUpdateBinary)
            .add("slug", slug)
            .add("forcePullContainer", forcePullContainer)
            .add("executorArgs", executorArgs)
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

        BoltComputationRequest other = (BoltComputationRequest)o;

        return
            Objects.equals(name, other.name) &&
            Objects.equals(instances, other.instances) &&
            Objects.equals(cpus, other.cpus) &&
            Objects.equals(mem, other.mem) &&
            Objects.equals(disk, other.disk) &&
            Objects.equals(taskHelper, other.taskHelper) &&
            Objects.equals(forceUpdateBinary, other.forceUpdateBinary) &&
            Arrays.equals(slug, other.slug) &&
            Objects.equals(forcePullContainer, other.forcePullContainer) &&
            Objects.equals(executorArgs, other.executorArgs);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            name,
            instances,
            cpus,
            mem,
            disk,
            taskHelper,
            forceUpdateBinary,
            slug,
            forcePullContainer,
            executorArgs
        });
    }
}
