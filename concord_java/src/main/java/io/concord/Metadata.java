package io.concord;

import io.concord.StreamTuple;
import io.concord.swift.StreamGrouping;
import java.util.Set;
import com.google.common.base.Preconditions;

public class Metadata {
  /** Globally unique identifier of the computation */
  public final String name;

  /** List of tuples of streams to subscribe this computation to. */
  public final Set<StreamTuple> istreams;

  /** List of streams this computation may produce on */
  public final Set<String> ostreams;

  public Metadata(String name, Set<StreamTuple> istreams,
                  Set<String> ostreams) {
    Preconditions.checkNotNull(name);
    Preconditions.checkNotNull(istreams);
    Preconditions.checkNotNull(ostreams);
    this.name = name;
    this.istreams = istreams;
    this.ostreams = ostreams;

    if (istreams.isEmpty() && ostreams.isEmpty()) {
      throw new RuntimeException("Both input and output streams are empty");
    }
  }
}
