package edu.chalmers.tda367.view;

import edu.chalmers.tda367.core.Monopoly;
import edu.chalmers.tda367.ctrl.BoardCtrl;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main stage (window) for the monopoly game.
 *
 * @author alex
 */
public class MainStage extends Stage {
  private Scene boardScene;

  public MainStage(Monopoly monopoly, BoardCtrl ctrl) {
    boardScene = BoardView.createBoardScene(monopoly, ctrl);
    setTitle("Monopoly");
    setScene(boardScene);
  }
}
