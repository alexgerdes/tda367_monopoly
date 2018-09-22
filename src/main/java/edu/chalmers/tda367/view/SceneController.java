package edu.chalmers.tda367.view;

import edu.chalmers.tda367.core.Monopoly;
import edu.chalmers.tda367.ctrl.Controller;
import edu.chalmers.tda367.service.Resources;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneController {
  private Controller controller;
  private Scene scene;

  public SceneController(String name, int width, int height) {
    try {
      FXMLLoader loader = Resources.getFXML(name);
      scene = new Scene(loader.load(), width, height);
      controller = loader.getController();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Scene getScene() {
    return scene;
  }

  public Controller getController() {
    return controller;
  }

  public void connectModel(Monopoly monopoly) {
    controller.connectModel(monopoly);
  }
}
