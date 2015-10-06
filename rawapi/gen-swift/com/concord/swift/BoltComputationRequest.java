package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
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
        @ThriftField(value=8, name="slug", requiredness=Requiredness.NONE) final byte [] slug
    ) {
        this.name = name;
        this.instances = instances;
        this.cpus = cpus;
        this.mem = mem;
        this.disk = disk;
        this.taskHelper = taskHelper;
        this.forceUpdateBinary = forceUpdateBinary;
        this.slug = slug;
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
        private byte [] slug;

        public Builder setSlug(byte [] slug) {
            this.slug = slug;
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
                this.slug
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

    private final byte [] slug;

    @ThriftField(value=8, name="slug", requiredness=Requiredness.NONE)
    public byte [] getSlug() { return slug; }

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
            .toString();
    }
}
