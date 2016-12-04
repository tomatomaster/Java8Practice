package ch03.ex05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorTransformer extends Application {

  public static void main(String[] args) throws IOException {
    launch(args);
  }

  public static Image transform(Image image, ColorTransformerInterface function) {
    int width = (int) image.getWidth();
    int height = (int) image.getHeight();
    WritableImage out = new WritableImage(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        out.getPixelWriter().setColor(i, j,
            function.apply(image.getPixelReader().getColor(i, j), i, j));
      }
    }
    return out;
  }

  @FunctionalInterface
  interface ColorTransformerInterface {
    Color apply(Color in, int x, int y);
  }

  @Override
  public void start(Stage arg0) throws Exception {
    ImageView view = new ImageView();
    view.setImage(readImageAndTransform());

    StackPane root = new StackPane();
    root.getChildren().add(view);

    Scene scene = new Scene(root, 200, 200);
    Stage stage = new Stage();
    stage.setTitle("Hello World!");
    stage.setScene(scene);
    stage.show();
  }
  
  public static Image readImageAndTransform() throws FileNotFoundException {
    String filePath = "res/image/icon.jpeg";
    final Image image = new Image(new FileInputStream(new File(filePath)));
    Image transformed = transform(image, (color, x, y) -> {
      int x_superior = (int) image.getWidth() - 10;
      int y_superiro = (int) image.getHeight() - 10;
      if (x < 10 || y < 10 || x > x_superior || y > y_superiro) {
        color = Color.GRAY;
      }
      return color;
    });
    return transformed;
  }
}
