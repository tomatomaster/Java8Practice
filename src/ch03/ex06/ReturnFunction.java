package ch03.ex06;


import java.util.function.BiFunction;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ReturnFunction extends Viewer {

  public static void main(String[] args) {
    setDefaultImage();
    setImage(getTransfomedImage());
    launch(args);
  }
  
  public static Image getTransfomedImage() {
    return transform(ReturnFunction.image, (color , fuctor) -> {
      for(int i=0; i < fuctor; i++)
        color = color.brighter();
      return color;
    }, 100);
  }
  
  public static <T> Image transform(Image image, BiFunction<Color, T, Color> function, T arg) {
    int width = (int)image.getWidth();
    int height= (int)image.getHeight();
    WritableImage out = new WritableImage(width, height);
    for(int x = 0; x < width; x++) {
      for(int y = 0; y < height; y++) {
        out.getPixelWriter().setColor(x, y, 
            function.apply(image.getPixelReader().getColor(x, y), arg));
      }
    }
    return out;
  }
}
