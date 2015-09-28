/**
 * WordSource.java
 * Concord Systems, Inc
 */

import com.concord.*;
import com.concord.swift.*;
import java.util.*;

/**
 * WordSource Computation
 * istreams: None
 * ostreams: ["words"]
 *
 * Emits random words onto the `words` stream from a set of 5 words.
 */
public class WordSource extends Computation {

  /** Working list of possible words to emit downstream */
  private final ArrayList<String> words =
    new ArrayList<String>(Arrays.asList("foo", "bar", "baz", "fiz", "buzz"));

  /** Returns a random word from `words` */
  private String sample() {
    int idx = new Random().nextInt(words.size());
    return words.get(idx);
  }

  public void init(ComputationContext ctx) throws Exception {
    System.out.println("WordSource.java initialized");
    ctx.setTimer("loop", System.currentTimeMillis());
  }

  public void processRecord(ComputationContext ctx, Record record)
    throws Exception {
    throw new Exception("Method not implemented");
  }

  public void processTimer(ComputationContext ctx, String key, long time)
    throws Exception {
    // Stream, key, value. Empty value, no need for val
    for (int i=0; i < 1024; ++i) {
      ctx.produceRecord("words".getBytes(),
                        this.sample().getBytes(),
                        "-".getBytes());
    }

    // Emit records every 100ms
    ctx.setTimer("main_loop", System.currentTimeMillis() + 100);
  }

  public Metadata metadata() throws Exception {
    return new Metadata("word-source",
                        new HashSet<Tuple<String, StreamGrouping>>(),
                        new HashSet<String>(Arrays.asList("words"))
      );
  }

  public static void main(String[] args) {
    try {
      ServeComputation.serve(new WordSource());
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }

}
