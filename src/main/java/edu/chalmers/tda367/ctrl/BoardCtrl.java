package edu.chalmers.tda367.ctrl;

import com.google.common.eventbus.Subscribe;
import edu.chalmers.tda367.core.Monopoly;
import edu.chalmers.tda367.core.event.DiceEvent;
import edu.chalmers.tda367.util.Pair;
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

  @Subscribe
  public void onEvent(DiceEvent e) {
    setDices(e.getDices());
  }

  public void setDices(Pair<Integer, Integer> dices) {
    dice1.setText(Integer.toString(dices.fst()));
    dice2.setText(Integer.toString(dices.snd()));
  }

  /**
   * Set active player label.
   *
   * @param name player's name
   */
  public void setActivePlayer(String name) {
    activePlayer.setText(name);
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
