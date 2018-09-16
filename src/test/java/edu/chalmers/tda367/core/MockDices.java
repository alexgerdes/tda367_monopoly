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

  @Override
  public int getTotal() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
