package edu.chalmers.tda367.ctrl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

/**
 * Controller for a street view.
 *
 * @author alexg
 */
public class StreetCtrl {
  public ListView<String> players;
  public Label street;
  public BorderPane root;
  private ObservableList<String> names;

  public StreetCtrl() {
     names = FXCollections.observableArrayList();
  }

  /**
   * Give the street a name.
   *
   * @param name street name
   */
  public void setStreet(String name) {
    street.setText(name);
  }

  /**
   * Add a player's name to the list of players currently on the street.
   *
   * @param name the player's name
   */
  @FXML
  public void addPlayer(String name) {
    names.add(name);
    players.setItems(names);
  }
}
