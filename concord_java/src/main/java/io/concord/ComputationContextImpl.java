package io.concord;

import io.concord.Metadata;
import io.concord.ComputationContext;
import io.concord.swift.ComputationTx;
import io.concord.swift.Record;
import io.concord.swift.BoltProxyService;
import io.concord.swift.BoltError;
import org.apache.thrift.TException;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.base.Throwables;
import java.util.*;

public class ComputationContextImpl extends ComputationContext {
  private final List<Record> records;
  private final Map<String, Long> timers;
  private final BoltProxyService client;

  public ComputationContextImpl(final BoltProxyService client) {
    Preconditions.checkNotNull(client);
    this.client = client;
    this.timers = new HashMap<String, Long>();
    this.records = new ArrayList<Record>();
  }

  public List<Record> getRecords() { return records; }

  public Map<String, Long> getTimers() { return timers; }

  public void produceRecord(final byte[] streamName, final byte[] binaryKey,
                            final byte[] binaryData) {
    Preconditions.checkNotNull(streamName);
    Preconditions.checkNotNull(binaryKey);
    Preconditions.checkNotNull(binaryData);
    Record r = new Record.Builder()
                   .setKey(binaryKey)
                   .setData(binaryData)
                   .setUserStream(streamName)
                   .build();
    records.add(r);
  }

  public void setTimer(final String key, long time) {
    Preconditions.checkNotNull(key);
    Preconditions.checkState(time > 0);
    timers.put(key, time);
  }

  public void setState(final String key, final byte[] binaryValue) {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(binaryValue);
    try {
      client.setState(key, binaryValue);
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
  }

  public byte[] getState(final String key) {
    byte[] ret;
    try {
      ret = client.getState(key);
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
    Verify.verify(ret != null, "Returned state, must always be a valid");
    return ret;
  }
}
