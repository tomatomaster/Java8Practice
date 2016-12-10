package ch03.ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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

  public Color[][] parallelTransform() {
    int pNum = Runtime.getRuntime().availableProcessors();
    int height = (int) in.getHeight();
    int width = (int) in.getWidth();
    Color[][] out = new Color[height][width];

    ExecutorService ePool = Executors.newCachedThreadPool();
    // 100 * 100
    // 4Core
    // 100(width) * 25(height) * 4
    try {
      for (int i = 0; i < pNum; i++) {
        int from = i * height / pNum;
        int to = (i + 1) * height / pNum;
        ePool.submit(() -> {
          System.out.println("ThreadNumber:" + Thread.currentThread().getId() + " From " + from + " To " + (to-1));
          for (int k = from; k < to; k++) {
            for (int j = 0; j < width; j++) {
              Color color = in.getPixelReader().getColor(j, k);
              for (final ColorTransformer operation : operations) {
                out[k][j] = operation.apply(j, k, color);
              }
            }
          }
        });
      }
      ePool.shutdown();
      ePool.awaitTermination(1, TimeUnit.HOURS);
    } catch (Exception e) {
    }
    return out;
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
    Color[][] colors = imageStream.form(image).transform(Color::brighter).transform(Color::invert)
        .transform((x, y, color) -> {
          if (x % 10 == 0 || y % 5 == 0)
            return color.darker().darker().darker();
          return color.brighter().brighter().invert();
        }).parallelTransform();
    image = toImage(colors, image);
    viewer.setImage(image);
    viewer.view();
  }

  public static Image toImage(Color[][] colors, Image image) {
    WritableImage out = new WritableImage((int) image.getWidth(), (int) image.getHeight());
    for (int w = 0; w < colors.length; w++) {
      for (int h = 0; h < colors[0].length; h++) {
        out.getPixelWriter().setColor(h, w, colors[w][h]);
      }
    }
    return out;
  }
}
