package edu.chalmers.tda367.view;

import com.google.common.eventbus.Subscribe;
import edu.chalmers.tda367.core.Monopoly;
import edu.chalmers.tda367.core.Player;
import edu.chalmers.tda367.core.Space;
import edu.chalmers.tda367.core.event.DiceEvent;
import edu.chalmers.tda367.ctrl.BoardCtrl;
import edu.chalmers.tda367.ctrl.StreetCtrl;
import edu.chalmers.tda367.service.Resources;
import edu.chalmers.tda367.util.Pair;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *  This view class draws the monopoly board. The source is an FXML file.
 *
 * @author alexg
 */
public class BoardView {
  // Config
  private static int WIDTH  = 11 * 80 + 20;
  private static int HEIGHT = 11 * 80 + 40;

  // Connections
  private Monopoly monopoly;  // the model
  private BoardCtrl ctrl;     // the controller

  // Mapping between space and view of space (Street)
  private Map<Space, StreetCtrl> spaceMap = new HashMap<>();

  public Label dice1;
  public Label dice2;
  public Label activePlayer;
  public HBox top;
  public HBox bottom;
  public VBox right;
  public VBox left;
  public BorderPane root;

  public BoardView() {
  }

  public static Scene createBoardScene(Monopoly monopoly, BoardCtrl ctrl) {
    BoardView view = Resources.getFXML("monopoly_board.fxml");
    view.monopoly = monopoly;
    view.ctrl = ctrl;
    view.initialise();

    Scene scene = new Scene(view.root, WIDTH, HEIGHT);
    monopoly.register(view);

    return scene;
  }

  private void initialise() {
    Iterator<Space> spaces = monopoly.getSpaces();

    for (int n = 0; spaces.hasNext(); n++) {
      Space space = spaces.next();
      StreetCtrl street = createStreet(space.getName());

      spaceMap.put(space, street);  // add to mapping

      if      (n < 11)
        top.getChildren().add(street.root);
      else if (n < 20)
        right.getChildren().add(street.root);
      else if (n < 31)
        bottom.getChildren().add(0, street.root);
      else
        left.getChildren().add(0, street.root);
    }

    setPlayers();
    setDices(monopoly.getDices());
  }

  private StreetCtrl createStreet(String name) {
    StreetCtrl street = Resources.getFXML("street.fxml");
    street.setStreet(name);
    return street;
  }

  //////// Handlers /////////

  @FXML
  private void onActionRoll(final ActionEvent event) {
    ctrl.onRoll();
  }

  @Subscribe
  public void onEvent(DiceEvent e) {
    setDices(e.getDices());
  }

  private void setDices(Pair<Integer, Integer> dices) {
    dice1.setText(Integer.toString(dices.fst()));
    dice2.setText(Integer.toString(dices.snd()));
  }

  //////// GUI updates //////////

  private void setPlayers() {
    Iterator<Player> players = monopoly.getPlayers();

    while (players.hasNext()) {
      Player player = players.next();
      StreetCtrl street = spaceMap.get(player.getPosition());
      street.addPlayer(player.getName());
    }

    setActivePlayer(monopoly.getActivePlayer().getName());
  }

  private void setActivePlayer(String name) {
    activePlayer.setText(name);
  }
}
