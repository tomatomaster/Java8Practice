package ch03.ex08;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.Test;

import ch03.ex15.Viewer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ReturnFunctionTest {

  @Test
  public void 枠の範囲のピクセルが黒くなっていることを確認() throws FileNotFoundException {
    Viewer view = new Viewer();
    view.setDefaultImage();
    Image dImage = view.getImage();
    boolean dResult = dImage.getPixelReader().getColor(10, 90).equals(Color.BLACK);
    Image transformed = ReturnFunction.readImageAndTransform(dImage, Color.BLACK, 100);
    boolean tResult = transformed.getPixelReader().getColor(10, 90).equals(Color.BLACK);
    assertFalse(dResult);
    assertTrue(tResult);
  }

}
