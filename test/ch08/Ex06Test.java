package ch08;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ch08.ex06.Ex06;
import javafx.geometry.Point2D;

public class Ex06Test {

  @Test
  public void testCompare() {
    Point2D a = new Point2D(1, 1);
    Point2D b = new Point2D(1, 1);
    int actual = new Ex06().compare(a, b);
    int expected = 0;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void bigXCompare() {
    Point2D a = new Point2D(2, 1);
    Point2D b = new Point2D(1, 1);
    int actual = new Ex06().compare(a, b);
    int expected = 1;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void bigYCompare() {
    Point2D a = new Point2D(1, 2);
    Point2D b = new Point2D(1, 1);
    int actual = new Ex06().compare(a, b);
    int expected = 1;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void smallXCompare() {
    Point2D a = new Point2D(0, 1);
    Point2D b = new Point2D(1, 1);
    int actual = new Ex06().compare(a, b);
    int expected = -1;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void smallYCompare() {
    Point2D a = new Point2D(1, 0);
    Point2D b = new Point2D(1, 1);
    int actual = new Ex06().compare(a, b);
    int expected = -1;
    assertThat(actual, is(expected));
  }

}
