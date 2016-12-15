package ch03.ex11;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class SyncColorTransformerTest {

  @Test
  public void test() {
    Viewer viewer = new Viewer();
    Viewer.setDefaultImage();
    Image image = Viewer.getImage();
    final Image out = image;
    image = SyncColorTransformer.syncTransform(out, SyncColorTransformer.toColorTransformer(Color::invert), (x, y, color) -> {
      int x_superior = (int) out.getWidth() - 10;
      int y_superiro = (int) out.getHeight() - 10;
      if (x < 10 || y < 10 || x > x_superior || y > y_superiro) {
        color = Color.GRAY;
      }
      return color;
    });
    Color actual = image.getPixelReader().getColor(100, 10);
    Color expected=out.getPixelReader().getColor(100, 10);
    assertNotEquals(actual, is(expected));
  }

}
