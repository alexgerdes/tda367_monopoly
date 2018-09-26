package edu.chalmers.tda367.core.event;

import edu.chalmers.tda367.util.Pair;

public final class DiceEvent {
  private final Pair<Integer, Integer> dices;

  public DiceEvent(int first, int second) {
    this(new Pair<>(first, second));
  }

  public DiceEvent(Pair<Integer, Integer> dices) {
    this.dices = dices;
  }

  public Pair<Integer, Integer> getDices() {
    return dices;
  }
}
