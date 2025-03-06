package edu.ntnu.iir.bidata;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage stage) {
    Scene scene = new Scene(new MainScene(), 640, 480);
    scene.setOnKeyPressed(event -> {
      switch (event.getCode()) {
        case ESCAPE -> stage.close();
      }
    });
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }

}