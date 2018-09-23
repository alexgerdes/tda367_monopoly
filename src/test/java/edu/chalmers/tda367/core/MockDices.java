package edu.chalmers.tda367.core;

/**
 * Used to eliminate Random behavior for tests
 *
 * @author alexg
 */
public class MockDices extends Dices {
  private int value;  // Some fixed value

  public MockDices(int value) {
    this.value = value;
  }

  protected int genInt() {
    return value;
  }
}
