package edu.chalmers.tda367.ctrl;

import edu.chalmers.tda367.core.Event;
import edu.chalmers.tda367.core.EventHandler;
import edu.chalmers.tda367.core.Monopoly;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class is the controller for the monopoly board. The source is an FXML file.
 *
 * @author alexg
 */
public class BoardCtrl implements ModelController, EventHandler {
  private Monopoly monopoly;

  public Label dice1;
  public Label dice2;
  public Label activePlayer;
  public HBox top;
  public HBox bottom;
  public VBox right;
  public VBox left;
  public BorderPane root;

  /**
   * Connect the model to the controller. Usually this is done via the constructor,
   * but JavaFX demands a constructor without any arguments.
   *
   * @param monopoly the model
   */
  @Override
  public void connectModel(Monopoly monopoly) {
    this.monopoly = monopoly;
    monopoly.register(this);
  }

  @FXML
  private void handleRoll(final ActionEvent event) {
    monopoly.move();
  }

  @Override
  public void onEvent(Event event) {
    switch (event.getTag()) {
      case DICE_FST:
        dice1.setText(event.getValue().toString());
        break;
      case DICE_SEC:
        dice2.setText(event.getValue().toString());
        break;
    }
  }

  /**
   * Add a gui item (node) to the top of a borderpane.
   *
   * @param node the node to be added
   */
  public void addTop(Node node) {
    top.getChildren().add(node);
  }

  /**
   * Add a gui item (node) to the right of a borderpane.
   *
   * @param node the node to be added
   */
  public void addRight(Node node) {
    right.getChildren().add(node);
  }

  /**
   * Add a gui item (node) to the bottom of a borderpane.
   *
   * @param node the node to be added
   */
  public void addBottom(Node node) {
    bottom.getChildren().add(0, node);
  }

  /**
   * Add a gui item (node) to the left of a borderpane.
   *
   * @param node the node to be added
   */
  public void addLeft(Node node) {
    left.getChildren().add(0, node);
  }
}
