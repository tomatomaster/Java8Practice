package ch03.ex14;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

import ch03.ex13.Viewer;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {

  private Image in;
  private List<ColorTransformer> operations = new ArrayList<ColorTransformer>();
  private static Map<Point, Color> cachedPixel = new HashMap<Point, Color>();

  public LatentImage form(Image in) {
    this.in = in;
    return this;
  }

  public static ColorTransformer adapter(UnaryOperator<Color> operator) {
    return new ColorTransformer() {
      @Override
      public Color apply(int x, int y, PixelReader reader) {
        return operator.apply(reader.getColor(x, y));
      }
    };
  }
  
  public LatentImage transform(ColorTransformer f) {
    operations.add(f);
    return this;
  }

  public Image getImage() {
    int width = (int) in.getWidth();
    int height = (int) in.getHeight();
    PixelReader reader = in.getPixelReader();

    
    WritableImage out = new WritableImage(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Color color = in.getPixelReader().getColor(i, j);
        for(int k = operations.size()-1; k > 1; k--) {
          cachedPixel operations.get(k).apply(i, j, reader);
          
          color = operations.get(k - 1).apply(i, j, operations.get(k).apply(i, j, color));
        }
        out.getPixelWriter().setColor(i, j, color);
      }
    }
    return out;
  }
  
  public static void main(String[] args) {
    Viewer viewer = new Viewer();
    viewer.setDefaultImage();
    
    LatentImage image = new LatentImage().form(viewer.getImage());
    image.transform((i, j, reader) -> {
      return reader.getColor(i-1, j-1);
    }).getImage();
  }
}
