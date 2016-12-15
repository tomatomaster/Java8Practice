package ch03.ex10;

import java.util.function.UnaryOperator;

import ch03.ex15.Viewer;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class UnaryTutorial {

  /**
   * A:期待される型と異なる型が返されるため<br>
   * ストラクチャル型の方が今回のような、型情報は異なるが構造が同一の場合に
   * 適応可能なので役立つ
   */
  public void dummy() {
    UnaryOperator<Color> op = Color::brighter;
    Image finalImage = transform(new Viewer().getImage(), op.compose(Color::brighter));
  }
  
  public static Image transform(Image image, UnaryOperator<Color> function) {
    int width = (int) image.getWidth();
    int height = (int) image.getHeight();
    WritableImage out = new WritableImage(width, height);
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        out.getPixelWriter().setColor(i, j,
            function.apply(image.getPixelReader().getColor(i, j)));
      }
    }
    return out;
  }
}
