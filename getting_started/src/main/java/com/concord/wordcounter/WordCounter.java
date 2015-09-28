/**
 * WordCounter.java
 * Concord Systems, Inc
 */

import com.concord.*;
import com.concord.swift.*;
import java.util.*;

/**
 * WordCounter computation
 * istreams: ("words", SHUFFLE)
 * ostreams: None
 *
 * Keeps a histogram of random words emitted from the `words` stream.
 * Prints its findings every 1024 records.
 */
public class WordCounter extends Computation {

  private final HashMap<String, Integer> histogram =
    new HashMap<String, Integer>();

  private int pidx = 0;

  public void init(ComputationContext ctx) throws Exception {
    System.out.println("WordCounter.java initialized");
  }

  public void processTimer(ComputationContext ctx, String key, long time)
    throws Exception {
    throw new Exception("Method not implemented");
  }

  public void processRecord(ComputationContext ctx, Record record)
    throws Exception {
    String key = new String(record.getKey(), "UTF-8");
    Integer currentValue = this.histogram.get(key);
    if (currentValue != null) {
      this.histogram.put(key, ++currentValue);
    } else {
      this.histogram.put(key, 1);
    }
    if (++this.pidx % 1024 == 0) {
      System.out.println(this.histogram.toString());
    }
  }

  public Metadata metadata() throws Exception {
    List<Tuple<String, StreamGrouping>> istreams =
      Arrays.asList(new Tuple<String, StreamGrouping>(
                      "words", StreamGrouping.SHUFFLE));

    return new Metadata("word-counter",
                        new HashSet<Tuple<String, StreamGrouping>>(istreams),
                        new HashSet<String>()
      );
  }

  public static void main(String[] args) {
    try {
      ServeComputation.serve(new WordCounter());
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }

}
