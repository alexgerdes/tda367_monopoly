package edu.chalmers.tda367.ctrl;

import edu.chalmers.tda367.core.Monopoly;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Pair;

public class BoardCtrl implements Controller {
  Monopoly monopoly;
  public Label dice1 = null;
  public Label dice2 = null;

  @Override
  public void connectModel(Monopoly monopoly) {
    this.monopoly = monopoly;
  }

  @FXML
  private void handleRoll(final ActionEvent event) {
    Pair<Integer, Integer> values = monopoly.move();
    dice1.setText(values.getValue().toString());
    dice2.setText(values.getKey().toString());
  }
}
