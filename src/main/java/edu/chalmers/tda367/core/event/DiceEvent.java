package edu.chalmers.tda367.core.event;

import edu.chalmers.tda367.util.Pair;

public final class DiceEvent {
  private final int first;
  private final int second;

  public DiceEvent(int first, int second) {
    this.first  = first;
    this.second = second;
  }

  public DiceEvent(Pair<Integer, Integer> pair) {
    this(pair.fst(), pair.snd());
  }

  public int getFirst() {
    return first;
  }

  public int getSecond() {
    return second;
  }
}
