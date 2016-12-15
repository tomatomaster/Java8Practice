package ch03.ex08;


import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ReturnFunction extends Viewer {

  public static void main(String[] args) throws FileNotFoundException {
    setDefaultImage();
    setImage(readImageAndTransform(image ,Color.BISQUE, 20));
    launch(args);
  }

  public static Image readImageAndTransform(Image image, Color flameColor, int flameSize)
      throws FileNotFoundException {
    Image transformed = transform(image, (color, x, y) -> {
      int x_superior = (int) image.getWidth() - flameSize;
      int y_superiro = (int) image.getHeight() - flameSize;
      if (x < flameSize || y < flameSize || x > x_superior || y > y_superiro) {
        color = flameColor;
      }
      return color;
    });
    return transformed;
  }

  @FunctionalInterface
  interface ColorTransformerInterface {
    Color apply(Color in, int x, int y);
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
}
