package ch04.ex07;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SampleApplication extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  Scene scene;

  @Override
  public void start(Stage stage) throws Exception {
    BorderPane pane = new BorderPane();
    Button button = new Button("Click");
    
    Color black = Color.BLACK;
    BorderStrokeStyle solid = BorderStrokeStyle.SOLID;
    BorderStrokeStyle dot   = BorderStrokeStyle.DOTTED;
    
    button.setBorder(new Border(new BorderStroke(
        black, black, black, black,
        solid, dot, solid, dot,
        new CornerRadii(0.5),
        new BorderWidths(2.0),
        new Insets(3.5))));
    
    pane.setCenter(button);
    
    scene = new Scene(pane, 250, 100);
    stage.setScene(scene);
    stage.show();
  }

}
