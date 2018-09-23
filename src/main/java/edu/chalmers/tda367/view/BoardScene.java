package edu.chalmers.tda367.view;

import edu.chalmers.tda367.core.Monopoly;
import edu.chalmers.tda367.core.Player;
import edu.chalmers.tda367.core.Space;
import edu.chalmers.tda367.ctrl.BoardCtrl;
import edu.chalmers.tda367.ctrl.StreetCtrl;
import edu.chalmers.tda367.service.Resources;
import javafx.scene.Scene;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This view class draws the monopoly board.
 *
 * @author alex
 */
public class BoardScene {
  private int WIDTH  = 11 * 80 + 20;
  private int HEIGHT = 11 * 80 + 40;
  BoardCtrl ctrl;
  Scene scene;
  Map<Space, StreetCtrl> spaceMap = new HashMap<>();

  public BoardScene(Monopoly monopoly) {
    ctrl = Resources.getFXML("monopoly_board.fxml");
    scene = new Scene(ctrl.root, WIDTH, HEIGHT);
    ctrl.connectModel(monopoly);

    createBoard(monopoly.getSpaces());

    placePlayers(monopoly.getPlayers());
  }

  private void createBoard(Iterator<Space> spaces) {
    for (int n = 0; spaces.hasNext(); n++) {
      Space space = spaces.next();
      StreetCtrl street = createStreet(space.getName());

      spaceMap.put(space, street);  // add to mapping

      if      (n < 11)
        ctrl.addTop(street.root);
      else if (n < 20)
        ctrl.addRight(street.root);
      else if (n < 31)
        ctrl.addBottom(street.root);
      else
        ctrl.addLeft(street.root);
    }
  }

  private StreetCtrl createStreet(String name) {
    StreetCtrl street = Resources.getFXML("street.fxml");
    street.setStreet(name);
    return street;
  }

  private void placePlayers(Iterator<Player> players) {
    while (players.hasNext()) {
      Player player = players.next();
      StreetCtrl street = spaceMap.get(player.getPosition());
      street.addPlayer(player.getName());
    }
  }

  /**
   * Return the scene created with this class.
   *
   * @return the monopoly board scene
   */
  public Scene getScene() {
    return scene;
  }
}
