package com.concord;

public abstract class ComputationContext {

  /**
   * Set local state for a given key
   *
   * @param: key:         Key to set in local store.
   * @param: binaryValue: Value to store at key.
   */
  public abstract void setState(final String key, final byte[] binaryValue);

  /**
   * Get local state for a given key
   *
   * @param key: Key to recrieve from local store.
   * @returns the state executed upon data retrieval.
   */
  public abstract byte[] getState(final String key);

  /**
   * Register a timer callback for some point in the future
   *
   * @param key:  Name of the timer callback.
   * @param time: The (ms since epoch) at which the callback should
   *              be fired
   */
  public abstract void setTimer(final String key, final long time);

  /**
   * Emit a record downstream
   *
   * @param streamName: The name of the stream on which the record should
   *                    be emitted.
   * @param binaryKey:  The key associated with the record. Only relevant
   *                    when routing method is `GROUP_BY`.
   * @param binaryData: The binary blob to send downstream.
   */
  public abstract void produceRecord(final byte[] streamName,
                                     final byte[] binaryKey,
                                     final byte[] binaryData);
}
