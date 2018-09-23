package edu.chalmers.tda367.view;

import edu.chalmers.tda367.core.Monopoly;
import javafx.stage.Stage;

/**
 * The main stage (window) for the monopoly game.
 *
 * @author alex
 */
public class MainStage extends Stage {
  private BoardScene boardScene;

  public MainStage(Monopoly monopoly) {
    boardScene = new BoardScene(monopoly);
    setTitle("Monopoly");
    setScene(boardScene.getScene());
  }
}
