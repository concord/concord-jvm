package com.concord;

import com.concord.swift.StreamGrouping;
import com.google.common.base.Preconditions;

public class StreamTuple {
  public final String streamName;
  public final StreamGrouping grouping;

  public StreamTuple(String streamName, StreamGrouping group) {
    Preconditions.checkNotNull(streamName);
    Preconditions.checkNotNull(group);
    this.streamName = streamName;
    this.grouping = group;
  }

  public int compareTo(StreamTuple rhs) {
    return com.google.common.collect.ComparisonChain.start()
        .compare(this.streamName, rhs.streamName)
        .compare(this.grouping, rhs.grouping)
        .result();
  }
}
