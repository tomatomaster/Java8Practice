package ch04.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BIndingApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage) throws Exception {
    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 200, 200);
    stage.setScene(scene);
    stage.setTitle("Hello");
    
    Circle circle = new Circle(100,100,100);
    
    circle.radiusProperty().bind(Bindings.divide(scene.widthProperty(),2));
    
    pane.setCenter(circle);
    stage.show();
  }

}
