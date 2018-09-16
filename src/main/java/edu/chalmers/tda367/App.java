package edu.chalmers.tda367;

import edu.chalmers.tda367.core.Monopoly;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;

public class App extends Application {
  private Monopoly monopoly;
  private Controller controller;

  @Override
  public void start(Stage primaryStage) throws Exception {
    String[] names = {"Mats", "Lise", "Sofie"};
    monopoly = Monopoly.createMonopoly(Arrays.asList(names));

    ClassLoader classLoader = new App().getClass().getClassLoader();
    FXMLLoader loader = new FXMLLoader(classLoader.getResource("monopoly_board.fxml"));
    Parent root = loader.load();
    controller = loader.getController();
    controller.connectModel(monopoly);

    primaryStage.setTitle("Monopoly");
    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
