package com.concord.swift;

import com.facebook.swift.codec.*;

public enum BackPressure
{
    NONE(0), ENQUEUE(1), DROP_HEAD(2), DROP_TAIL(3), BLOCK_SENDER(4);

    private final int value;

    BackPressure(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
