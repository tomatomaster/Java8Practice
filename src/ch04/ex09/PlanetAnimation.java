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
    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 1050, 1050);

    
    PathTransition pathTransition = new PathTransition();

    double left = 0.0;
    double right= 10.0;
    double top  = 0.0;
    double bottom = 10.0;

    double halfWidth = scene.getWidth()/2;
    double halfHeight= scene.getHeight()/2;
    
    double x0 = left + halfWidth; 
    double y1 = top  + halfHeight;

    double cw = 4.0 * (Math.sqrt(2.0) -1.0) * halfWidth / 3.0;
    double ch = 4.0 * (Math.sqrt(2.0) -1.0) * halfHeight/ 3.0;
    
    Path path = new Path();
    path.getElements().add(new MoveTo(0, 0));
    path.getElements().add(new CubicCurveTo(x0 + cw, top, right, y1 - ch, right, y1));
    path.getElements().add(new CubicCurveTo(right, y1 + ch, x0 + cw, bottom, x0, bottom));
    path.getElements().add(new CubicCurveTo(x0 - cw, bottom, left, y1 + ch, left, y1));
    path.getElements().add(new CubicCurveTo(left, y1 - ch, x0 - cw, top, x0, top));
    path.getElements().add(new MoveTo(0, 0));
    pathTransition.setDuration(Duration.millis(10000));
    pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
    pathTransition.setCycleCount(4);
    pathTransition.setAutoReverse(true);
    pathTransition.setCycleCount(1000);
    pathTransition.setPath(path);
    pathTransition.setNode(earth);

    pathTransition.play();
    
    pane.setCenter(earth);    
    stage.setScene(scene);
    stage.setTitle("Hello");

    stage.show();
  }

}
