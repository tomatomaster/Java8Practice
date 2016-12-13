package ch04.ex06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneLayout extends Application {
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    BorderPane pane = new BorderPane();
    
    Button top = new Button("Top");    
    pane.setTop(top);
    pane.setAlignment(top, Pos.CENTER);
    
    pane.setLeft(new Button("Left"));
    pane.setCenter(new Button("Center"));
    pane.setRight(new Button("Right"));
    
    Button buttom = new Button("Buttom");
    pane.setBottom(buttom);
    pane.setAlignment(buttom, Pos.CENTER);
    
    Scene scene = new Scene(pane, 150, 80);
    stage.setScene(scene);
    stage.setTitle("Hello");

    stage.show();
  }

}
