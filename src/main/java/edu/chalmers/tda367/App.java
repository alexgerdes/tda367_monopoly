package edu.chalmers.tda367;

import edu.chalmers.tda367.core.Monopoly;
import edu.chalmers.tda367.view.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class App extends Application {
  @Override
  public void start(Stage primaryStage) {
    String[] names = {"Mats", "Lise", "Sofie"};

    Monopoly monopoly = Monopoly.createMonopoly(Arrays.asList(names));
    MainStage stage = new MainStage(monopoly);

    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
