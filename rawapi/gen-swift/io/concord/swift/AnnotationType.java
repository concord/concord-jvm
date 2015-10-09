package com.concord.swift;

import com.facebook.swift.codec.*;

public enum AnnotationType
{
    CLIENT_SEND(0), CLIENT_RECV(1), SERVER_SEND(2), SERVER_RECV(3);

    private final int value;

    AnnotationType(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
