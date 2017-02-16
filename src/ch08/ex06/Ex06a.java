package ch08.ex06;

import java.util.Comparator;

import javafx.geometry.Rectangle2D;

public class Ex06a implements Comparator<Rectangle2D>{

  @Override
  public int compare(Rectangle2D o1, Rectangle2D o2) {
    double x = o1.getMaxX() - o2.getMaxX();
    double y = o1.getMaxY() - o2.getMaxY();
    if(x > 0) {
      return 1;
    } else if(x < 0) {
      return -1;
    }
    if(y > 0) {
      return 1;
    } else if(y < 0) {
      return -1;
    }
    return 0;
  }

}
