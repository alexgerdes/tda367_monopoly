package edu.chalmers.tda367.core;

import edu.chalmers.tda367.core.event.DiceEvent;
import javafx.util.Pair;

import java.util.Random;

/**
 * Monopoly specific pair of dices
 *
 * @author alexg
 */
class Dices {
  private final Random rand = new Random();
  private final int MAX = 6;  // Number of sides of a dice

  private int first = 1;   // Values for dices
  private int second = 1;

  /**
   * Roll both dices: update the dice values with random integers between 1 and MAX.
   */
  public void roll() {
    first  = genInt();
    second = genInt();

    Monopoly.bus.post(new DiceEvent(first, second));
  }

  protected int genInt() {
    return rand.nextInt(MAX) + 1;
  }

  /**
   * Dice values in a pair.
   *
   * @return a Pair with the current dice values
   */
  public Pair<Integer, Integer> getValues() {
    return new Pair<>(first, second);
  }

  /**
   * Get the total number of points.
   *
   * @return the sum of the two dices.
   */
  public int getTotal() {
    return first + second;
  }

  /**
   * Check if both dices have the maximum value.
   *
   * @return if the value of both dices is max.
   */
  public boolean isHighScore() {
    return first == second && first == MAX;
  }
}
