package edu.chalmers.tda367.core.event;

public final class DiceEvent {
  private final int first;
  private final int second;

  public DiceEvent(int first, int second) {
    this.first  = first;
    this.second = second;
  }

  public int getFirst() {
    return first;
  }

  public int getSecond() {
    return second;
  }
}
