package ch03.ex06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Viewer extends Application {

  static Image image;
  static int viewer_with;
  static int viewer_height;
  
  public static void setImage(Image image) {
   Viewer.image = image;
  }
  
  public static void main(String[] args) throws IOException {
    launch(args);
  }

  public static void setDefaultImage() {
    String filePath = "res/image/icon.jpeg";
    Image image = null;
    try {
      image = new Image(new FileInputStream(new File(filePath)));
    } catch (FileNotFoundException e) {}
    Viewer.image = image;
  }
  
  @Override
  public void start(Stage arg0) throws Exception {
    ImageView view = new ImageView();
    view.setImage(Viewer.image);

    StackPane root = new StackPane();
    root.getChildren().add(view);

    Scene scene = new Scene(root, 200, 200);
    Stage stage = new Stage();
    stage.setTitle("Hello World!");
    stage.setScene(scene);
    stage.show();
  }
  
  static void setDisplaySize(int width, int height) {
    Viewer.viewer_with = width;
    Viewer.viewer_height = height;
  }

  static void setViewer_with(int viewer_with) {
    Viewer.viewer_with = viewer_with;
  }
  

  static void setViewer_height(int viewer_height) {
    Viewer.viewer_height = viewer_height;
  }
  
}
