package ch03.ex12;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
  private Image in;
  private List<ColorTransformer> operations = new ArrayList<ColorTransformer>();

  public LatentImage form(Image in) {
    this.in = in;
    return this;
  }

  public Image getImage() {
    int width = (int) in.getWidth();
    int height = (int) in.getHeight();
    WritableImage out = new WritableImage(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        Color color = in.getPixelReader().getColor(i, j);
        for (ColorTransformer operation : operations) {
          color = operation.apply(i, j, color);
        }
        out.getPixelWriter().setColor(i, j, color);
      }
    }
    return out;
  }

  public LatentImage transform(UnaryOperator<Color> f) {
    operations.add(toColorTransformer(f));
    return this;
  }

  public LatentImage transform(ColorTransformer f) {
    operations.add(f);
    return this;
  }

  private static ColorTransformer toColorTransformer(UnaryOperator<Color> unary) {
    return new ColorTransformer() {
      @Override
      public Color apply(int x, int y, Color color) {
        return unary.apply(color);
      }
    };
  }

  public static void main(String[] args) {
    Viewer viewer = new Viewer();
    viewer.setDefaultImage();
    Image image = viewer.getImage();
    LatentImage imageStream = new LatentImage();
    image = imageStream.form(image).transform(Color::brighter).transform(Color::invert).
    transform((x, y, color) -> {
      if(x%10 == 0 || y%5 == 0)
        return color.darker().darker().darker();
      return color.brighter().brighter();
    }).getImage();
    viewer.setImage(image);
    viewer.view();
  }
}
