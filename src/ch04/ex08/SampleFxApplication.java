package ch04.ex08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SampleFxApplication extends Application {

  
  public static void main(String[] args) {
    launch(args);
  }
  
  private Scene scene;
  
    @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Mozaic");
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

}
