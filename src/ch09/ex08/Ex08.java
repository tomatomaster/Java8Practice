package ch09.ex08;

import java.awt.Point;

public class Ex08 {

  public static void main(String[] args) {
    Point p1 = new Point(5, 15);
    Point p2 = new Point(5, 15);
    int result = new Ex08().compare(p1, p2);
    System.out.println(result);
  }

  /**
   * Check which is bigger, {@code self} or {@code other}.
   * If self.x == other.x && self.y == other.y, then return 0;
   * If self.x > other.x then return 1, the other return -1.
   * 
   * @param self
   * @param other
   * @return 
   */
  public int compare(Point self, Point other) {
    if (self.x != other.x) {
      return (self.x < other.x) ? -1 : 1;
    } else {
      if(self.y != other.y){
        return (self.y < other.y) ? -1 : 1; 
      } else {
        return 0;
      }
    }
  }
}
