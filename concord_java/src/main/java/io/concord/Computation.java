package io.concord;

import io.concord.Metadata;
import io.concord.ComputationContext;
import io.concord.swift.Record;

public abstract class Computation {

  /**
   * Called when the framework has registered the computation successfully.
   * Gives users a first opportunity to schedule timer callbacks and
   * produce records.
   *
   * @param ctx: The computation context object provided by the system.
   */
  public abstract void init(ComputationContext ctx);

  /**
   * Called when the framework is ready to shutdown the computation.
   * Gives users a chance to perform some cleanup before the process
   * is killed.
   */
  public abstract void destroy();

  /**
   * Process incoming records on one of the computation's `istreams`.
   *
   * @param ctx: The computation context object provided by the system.
   * @param record: The `Record` to emit downstream.
   */
  public abstract void processRecord(ComputationContext ctx, Record record);

  /**
   * Process a timer callback previously set via `setTimer`.
   *
   * @param ctx: The computation context object provided by the system.
   * @param key: The name of the timer.
   * @param time: The time (in ms) for which teh callback was scheduled.
   */
  public abstract void processTimer(ComputationContext ctx, String key,
                                    long time);

  /**
   * This function is called by the concord proxy to identify the user
   * computation.
   *
   * @returns: Metadata object representing the user computation.
   */
  public abstract Metadata metadata();
}
