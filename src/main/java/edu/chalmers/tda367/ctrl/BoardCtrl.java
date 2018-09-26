package edu.chalmers.tda367.ctrl;

import edu.chalmers.tda367.core.Monopoly;

/**
 * This class is the controller for the monopoly board.
 *
 * @author alex
 */
public class BoardCtrl {
  // Connections
  private Monopoly monopoly;  // the model

  public BoardCtrl(Monopoly monopoly) {
    this.monopoly = monopoly;
  }

  public void onRoll() {
    monopoly.move();
  }
}
