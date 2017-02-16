package ch08.ex06;

import java.util.Comparator;

import javafx.geometry.Point2D;

public class Ex06 implements Comparator<Point2D>{
  
  @Override
  public int compare(Point2D o1, Point2D o2) {
    double x = o1.getX() - o2.getX();
    double y = o1.getY() - o2.getY();
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
