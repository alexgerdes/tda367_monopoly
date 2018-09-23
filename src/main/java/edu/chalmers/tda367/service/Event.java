package edu.chalmers.tda367.service;

public final class Event {

  // All possible (so far) events listed
  public enum Tag {
    PLAYER_BUY,
    PLAYER_BALANCE,
    PLAYER_IN_JAIL,
    PLAYER_POSITION,
    DICE_FST,
    DICE_SEC,
    MONOPOLY_NEXT,
  }

  private final Tag tag;
  // Data to send
  private final Object value;

  public Event(Tag tag, Object value) {
    this.tag = tag;
    this.value = value;
  }

  public Tag getTag() {
    return tag;
  }

  public Object getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Event [tag=" + tag + ", value=" + value + "]";
  }
}
