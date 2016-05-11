package io.concord.swift;

import com.facebook.swift.codec.*;

public enum RecordFlags
{
    CLIENT_RECORD(1), FRAMEWORK_RECORD(2);

    private final int value;

    RecordFlags(int value)
    {
        this.value = value;
    }

    @ThriftEnumValue
    public int getValue()
    {
        return value;
    }
}
