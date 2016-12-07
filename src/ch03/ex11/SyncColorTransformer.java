package ch03.ex11;

import java.io.IOException;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class SyncColorTransformer {

  public static void main(String[] args) throws IOException {
    Viewer viewer = new Viewer();
    Viewer.setDefaultImage();
    Image image = Viewer.getImage();
    final Image out = image;
    image = syncTransform(out, toColorTransformer(Color::brighter), (x, y, color) -> {
      int x_superior = (int) out.getWidth() - 10;
      int y_superiro = (int) out.getHeight() - 10;
      if (x < 10 || y < 10 || x > x_superior || y > y_superiro) {
        color = Color.GRAY;
      }
      return color;
    });
    Viewer.setImage(image);
    Viewer.view();
  }

  public static Image syncTransform(Image image, ColorTransformer op1, ColorTransformer op2) {
    int w = (int) image.getWidth();
    int h = (int) image.getHeight();
    WritableImage out = new WritableImage(w, h);
    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        Color inputC = image.getPixelReader().getColor(i, j);
        Color transC = op1.apply(i, j, op2.apply(i, j, inputC));
        out.getPixelWriter().setColor(i, j, transC);
      }
    }
    return out;
  }

  public static ColorTransformer toColorTransformer(UnaryOperator<Color> unary) {
    return new ColorTransformer() {
      @Override
      public Color apply(int x, int y, Color color) {
        return unary.apply(color);
      }
    };
  }

  @FunctionalInterface
  interface ColorTransformer {
    Color apply(int x, int y, Color color);
  }
}
