package edu.chalmers.tda367.ctrl;

import edu.chalmers.tda367.core.Monopoly;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class BoardCtrl implements ModelController {
  private Monopoly monopoly;

  public Label dice1;
  public Label dice2;
  public Label activePlayer;
  public HBox top;
  public HBox bottom;
  public VBox right;
  public VBox left;
  public BorderPane root;

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

  public void addTop(Node node) {
    top.getChildren().add(node);
  }

  public void addRight(Node node) {
    right.getChildren().add(node);
  }

  public void addBottom(Node node) {
    bottom.getChildren().add(0, node);
  }

  public void addLeft(Node node) {
    left.getChildren().add(0, node);
  }
}
