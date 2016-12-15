package ch03.ex05;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch03.ex15.Viewer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ColorTransformerTest {

  @Test
  public void testTransform() {
    Viewer viewer = new Viewer();
    viewer.setDefaultImage();
    Image image = viewer.getImage();

    Color original = image.getPixelReader().getColor(50, 100);
    Color transformedColor = ColorTransformer.transform(image, (color, x, y) -> {
      return Color.BLUE;
    }).getPixelReader().getColor(50, 100);

    boolean result = original.getBlue() < transformedColor.getBlue();
    assertTrue(result);
  }

}
