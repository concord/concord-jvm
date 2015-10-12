package com.concord.swift;

import com.facebook.swift.codec.*;

public enum Signal
{
    START(0), ACTIVE(1), INACTIVE(2), SHUTDOWN(3), KILL(4);

    private final int value;

    Signal(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
