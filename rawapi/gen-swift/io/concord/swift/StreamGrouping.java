package io.concord.swift;

import com.facebook.swift.codec.*;

public enum StreamGrouping
{
    ROUND_ROBIN(0), SHUFFLE(1), GROUP_BY(2), LOCAL(3), CUSTOM(100);

    private final int value;

    StreamGrouping(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
