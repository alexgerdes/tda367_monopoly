package edu.chalmers.tda367.ctrl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class StreetCtrl {
  public ListView<String> players;
  public Label street;
  public BorderPane root;
  private ObservableList<String> names;

  public StreetCtrl() {
     names = FXCollections.observableArrayList();
  }

  public void setStreet(String name) {
    street.setText(name);
  }

  @FXML
  public void addPlayer(String name) {
    names.add(name);
    players.setItems(names);
  }
}
