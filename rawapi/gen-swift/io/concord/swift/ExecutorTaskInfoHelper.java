package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("ExecutorTaskInfoHelper")
public final class ExecutorTaskInfoHelper
{
    @ThriftConstructor
    public ExecutorTaskInfoHelper(
        @ThriftField(value=1, name="frameworkLoggingLevel", requiredness=Requiredness.NONE) final int frameworkLoggingLevel,
        @ThriftField(value=2, name="user", requiredness=Requiredness.NONE) final String user,
        @ThriftField(value=3, name="frameworkVModule", requiredness=Requiredness.NONE) final String frameworkVModule,
        @ThriftField(value=4, name="scheduler", requiredness=Requiredness.NONE) final Endpoint scheduler,
        @ThriftField(value=5, name="proxy", requiredness=Requiredness.NONE) final Endpoint proxy,
        @ThriftField(value=6, name="client", requiredness=Requiredness.NONE) final Endpoint client,
        @ThriftField(value=7, name="execName", requiredness=Requiredness.NONE) final String execName,
        @ThriftField(value=8, name="folder", requiredness=Requiredness.NONE) final String folder,
        @ThriftField(value=9, name="computationAliasName", requiredness=Requiredness.NONE) final String computationAliasName,
        @ThriftField(value=10, name="clientArguments", requiredness=Requiredness.NONE) final List<String> clientArguments,
        @ThriftField(value=11, name="environmentExtra", requiredness=Requiredness.NONE) final List<String> environmentExtra,
        @ThriftField(value=12, name="dockerContainer", requiredness=Requiredness.NONE) final String dockerContainer
    ) {
        this.frameworkLoggingLevel = frameworkLoggingLevel;
        this.user = user;
        this.frameworkVModule = frameworkVModule;
        this.scheduler = scheduler;
        this.proxy = proxy;
        this.client = client;
        this.execName = execName;
        this.folder = folder;
        this.computationAliasName = computationAliasName;
        this.clientArguments = clientArguments;
        this.environmentExtra = environmentExtra;
        this.dockerContainer = dockerContainer;
    }

    public static class Builder {
        private int frameworkLoggingLevel;

        public Builder setFrameworkLoggingLevel(int frameworkLoggingLevel) {
            this.frameworkLoggingLevel = frameworkLoggingLevel;
            return this;
        }
        private String user;

        public Builder setUser(String user) {
            this.user = user;
            return this;
        }
        private String frameworkVModule;

        public Builder setFrameworkVModule(String frameworkVModule) {
            this.frameworkVModule = frameworkVModule;
            return this;
        }
        private Endpoint scheduler;

        public Builder setScheduler(Endpoint scheduler) {
            this.scheduler = scheduler;
            return this;
        }
        private Endpoint proxy;

        public Builder setProxy(Endpoint proxy) {
            this.proxy = proxy;
            return this;
        }
        private Endpoint client;

        public Builder setClient(Endpoint client) {
            this.client = client;
            return this;
        }
        private String execName;

        public Builder setExecName(String execName) {
            this.execName = execName;
            return this;
        }
        private String folder;

        public Builder setFolder(String folder) {
            this.folder = folder;
            return this;
        }
        private String computationAliasName;

        public Builder setComputationAliasName(String computationAliasName) {
            this.computationAliasName = computationAliasName;
            return this;
        }
        private List<String> clientArguments;

        public Builder setClientArguments(List<String> clientArguments) {
            this.clientArguments = clientArguments;
            return this;
        }
        private List<String> environmentExtra;

        public Builder setEnvironmentExtra(List<String> environmentExtra) {
            this.environmentExtra = environmentExtra;
            return this;
        }
        private String dockerContainer;

        public Builder setDockerContainer(String dockerContainer) {
            this.dockerContainer = dockerContainer;
            return this;
        }

        public Builder() { }
        public Builder(ExecutorTaskInfoHelper other) {
            this.frameworkLoggingLevel = other.frameworkLoggingLevel;
            this.user = other.user;
            this.frameworkVModule = other.frameworkVModule;
            this.scheduler = other.scheduler;
            this.proxy = other.proxy;
            this.client = other.client;
            this.execName = other.execName;
            this.folder = other.folder;
            this.computationAliasName = other.computationAliasName;
            this.clientArguments = other.clientArguments;
            this.environmentExtra = other.environmentExtra;
            this.dockerContainer = other.dockerContainer;
        }

        public ExecutorTaskInfoHelper build() {
            return new ExecutorTaskInfoHelper (
                this.frameworkLoggingLevel,
                this.user,
                this.frameworkVModule,
                this.scheduler,
                this.proxy,
                this.client,
                this.execName,
                this.folder,
                this.computationAliasName,
                this.clientArguments,
                this.environmentExtra,
                this.dockerContainer
            );
        }
    }

    private final int frameworkLoggingLevel;

    @ThriftField(value=1, name="frameworkLoggingLevel", requiredness=Requiredness.NONE)
    public int getFrameworkLoggingLevel() { return frameworkLoggingLevel; }

    private final String user;

    @ThriftField(value=2, name="user", requiredness=Requiredness.NONE)
    public String getUser() { return user; }

    private final String frameworkVModule;

    @ThriftField(value=3, name="frameworkVModule", requiredness=Requiredness.NONE)
    public String getFrameworkVModule() { return frameworkVModule; }

    private final Endpoint scheduler;

    @ThriftField(value=4, name="scheduler", requiredness=Requiredness.NONE)
    public Endpoint getScheduler() { return scheduler; }

    private final Endpoint proxy;

    @ThriftField(value=5, name="proxy", requiredness=Requiredness.NONE)
    public Endpoint getProxy() { return proxy; }

    private final Endpoint client;

    @ThriftField(value=6, name="client", requiredness=Requiredness.NONE)
    public Endpoint getClient() { return client; }

    private final String execName;

    @ThriftField(value=7, name="execName", requiredness=Requiredness.NONE)
    public String getExecName() { return execName; }

    private final String folder;

    @ThriftField(value=8, name="folder", requiredness=Requiredness.NONE)
    public String getFolder() { return folder; }

    private final String computationAliasName;

    @ThriftField(value=9, name="computationAliasName", requiredness=Requiredness.NONE)
    public String getComputationAliasName() { return computationAliasName; }

    private final List<String> clientArguments;

    @ThriftField(value=10, name="clientArguments", requiredness=Requiredness.NONE)
    public List<String> getClientArguments() { return clientArguments; }

    private final List<String> environmentExtra;

    @ThriftField(value=11, name="environmentExtra", requiredness=Requiredness.NONE)
    public List<String> getEnvironmentExtra() { return environmentExtra; }

    private final String dockerContainer;

    @ThriftField(value=12, name="dockerContainer", requiredness=Requiredness.NONE)
    public String getDockerContainer() { return dockerContainer; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("frameworkLoggingLevel", frameworkLoggingLevel)
            .add("user", user)
            .add("frameworkVModule", frameworkVModule)
            .add("scheduler", scheduler)
            .add("proxy", proxy)
            .add("client", client)
            .add("execName", execName)
            .add("folder", folder)
            .add("computationAliasName", computationAliasName)
            .add("clientArguments", clientArguments)
            .add("environmentExtra", environmentExtra)
            .add("dockerContainer", dockerContainer)
            .toString();
    }
}
