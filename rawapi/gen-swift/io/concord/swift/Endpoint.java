package com.concord.swift;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

@ThriftStruct("Endpoint")
public final class Endpoint
{
    @ThriftConstructor
    public Endpoint(
        @ThriftField(value=1, name="ip", requiredness=Requiredness.NONE) final String ip,
        @ThriftField(value=2, name="port", requiredness=Requiredness.NONE) final int port
    ) {
        this.ip = ip;
        this.port = port;
    }

    public static class Builder {
        private String ip;

        public Builder setIp(String ip) {
            this.ip = ip;
            return this;
        }
        private int port;

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder() { }
        public Builder(Endpoint other) {
            this.ip = other.ip;
            this.port = other.port;
        }

        public Endpoint build() {
            return new Endpoint (
                this.ip,
                this.port
            );
        }
    }

    private final String ip;

    @ThriftField(value=1, name="ip", requiredness=Requiredness.NONE)
    public String getIp() { return ip; }

    private final int port;

    @ThriftField(value=2, name="port", requiredness=Requiredness.NONE)
    public int getPort() { return port; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("ip", ip)
            .add("port", port)
            .toString();
    }
}
