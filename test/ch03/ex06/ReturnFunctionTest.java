package ch03.ex06;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import ch03.ex15.Viewer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ReturnFunctionTest {

  @Test
  public void testTransform() {
    Viewer view = new Viewer();
    view.setDefaultImage();
    Image image = view.getImage();
    Image transformedImage = getTransfomedImage(image);
    Color orignal = image.getPixelReader().getColor(10, 10);
    Color transformed = transformedImage.getPixelReader().getColor(10, 10);
    assertNotEquals(orignal, is(transformed));
  }
  
  public static Image getTransfomedImage(Image image) {
    return ReturnFunction.transform(image, (color , fuctor) -> {
      for(int i= 0; i < fuctor; i++)
        color = color.darker();
      return color;
    }, 4);
  }

}
