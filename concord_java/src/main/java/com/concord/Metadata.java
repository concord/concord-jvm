/**
 * Metadata.java
 * Concord Systems, Inc
 */

package com.concord;
import com.concord.Tuple;
import com.concord.swift.StreamGrouping;
import java.io.*;
import java.util.Set;

/**
 * High-level wrapper for `ComputationMetadata`
 */
public class Metadata {
  /** Globally unique identifier of the computation */
  public final String name;

  /** List of tuples of streams to subscribe this computation to. */
  public final Set<Tuple<String, StreamGrouping> > istreams;

  /** List of streams this computation may produce on */
  public final Set<String> ostreams;

  /**
   * Creates a new 'Metadata' object
   * @throws Exception: if both input and output streams are empty
   */
  public Metadata(String name,
                  Set<Tuple<String, StreamGrouping> > istreams,
                  Set<String> ostreams) throws Exception {
    this.name = name;
    this.istreams = istreams;
    this.ostreams = ostreams;

    if (istreams.isEmpty() && ostreams.isEmpty()) {
      throw new Exception("Both input and output streams are empty");
    }
  }
}
