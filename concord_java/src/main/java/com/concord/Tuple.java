/**
 * Tuple class for Concord
 * Synopsis: Encapsulates two objects
 */

package com.concord;

public class Tuple<T, U> implements Comparable<Tuple<T, U>> {
  public final T first;
  public final U second;

  public Tuple(T first, U second) {
    this.first = first;
    this.second = second;
  }

  public int compareTo(Tuple<T, U> other) {
    return 0;
  }
}
