/**
 * ComputationContext class for Concord
 * Synopsis: ComputationContextImpl
 */

package com.concord;

import com.concord.Metadata;
import com.concord.ComputationContext;

import com.concord.swift.ComputationTx;
import com.concord.swift.Record;
import com.concord.swift.BoltProxyService;
import com.concord.swift.BoltError;
import org.apache.thrift.TException;

import java.util.*;

public class ComputationContextImpl extends ComputationContext {
  private final List<Record> records;

  private final Map<String, Long> timers;

  private final BoltProxyService client;

  public ComputationContextImpl(BoltProxyService client) {
    this.client = client;
    this.timers = new HashMap<String, Long>();
    this.records = new ArrayList<Record>();
  }

  public List<Record> getRecords() {
    return records;
  }

  public Map<String, Long> getTimers() {
    return timers;
  }

  public void produceRecord(byte[] streamName, byte[] binaryKey, byte[] binaryData) {
    assert streamName != null;
    Record r = new Record
      .Builder()
      .setKey(binaryKey)
      .setData(binaryData)
      .setUserStream(streamName)
      .build();
    records.add(r);
  }

  public void setTimer(String key, long time) {
    if (time > 0) {
      timers.put(key, time);
    } else {
      System.out.println("Timeout MUST be greater than 0. Skipping timeout: " + time);
    }
  }

  public void setState(String key, byte[] binaryValue) {
    try {
      client.setState(key, binaryValue);
    } catch (BoltError boltError) {
      System.out.println("Error when attempting to set state: " + boltError);
    } catch (TException thriftError) {
      System.out.println("Thrift error occurred when setting state: " + thriftError);
    }
  }

  public byte[] getState(String key) {
    try {
      return client.getState(key);
    } catch (BoltError boltError) {
      System.out.println("Error when attempting to fetch state: " + boltError);
      return null;
    } catch (TException thriftError) {
      System.out.println("Thrift error occurred when fetching state: " + thriftError);
      return null;
    }
  }
}
