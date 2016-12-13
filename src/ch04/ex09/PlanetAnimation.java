package ch04.ex09;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PlanetAnimation extends Application {

  Circle earth = new Circle(10, 10, 10);
  Circle moon = new Circle(10, 10, 10);
  Circle sun = new Circle(10, 10, 10);

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    PathTransition pathTransition = new PathTransition();
    pathTransition.setAutoReverse(true);
    pathTransition.setCycleCount(10);

    Path path = new Path();
    path.getElements().add(new MoveTo(0f, 50f));
    path.getElements().add(new CubicCurveTo(40f, 10f, 390f, 240f, 1904, 50f));
    pathTransition.setPath(path);

    pathTransition.setNode(earth);
    BorderPane pane = new BorderPane();
    pane.setCenter(earth);

    pathTransition.setDuration(Duration.millis(10000));
    pathTransition.setPath(path);
    pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
    pathTransition.setCycleCount(4);


    pathTransition.play();

    Scene scene = new Scene(pane, 1050, 1050);
    stage.setScene(scene);
    stage.setTitle("Hello");

    stage.show();
  }

}
