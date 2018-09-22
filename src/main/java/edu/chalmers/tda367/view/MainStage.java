package edu.chalmers.tda367.view;

import edu.chalmers.tda367.core.Monopoly;
import edu.chalmers.tda367.ctrl.BoardCtrl;
import javafx.stage.Stage;

public class MainStage extends Stage {
  private SceneController boardScene;
  private int WIDTH = 600;
  private int HEIGHT = 600;

  public MainStage() {
    boardScene = new SceneController("monopoly_board.fxml", WIDTH, HEIGHT);

    setTitle("Monopoly");
    setScene(boardScene.getScene());
  }

  public void connectModel(Monopoly monopoly) {
    boardScene.getController().connectModel(monopoly);
  }
}
