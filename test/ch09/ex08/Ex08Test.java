package ch09.ex08;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.junit.Test;

public class Ex08Test {

  @Test
  public void same() {
    Ex08 test = new Ex08();
    Point self = new Point(0, 0);
    Point other= new Point(0, 0);
    int actual = test.compare(self, other);
    int expected = 0;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void aboveX() {
    Ex08 test = new Ex08();
    Point self = new Point(1, 0);
    Point other= new Point(0, 0);
    int actual = test.compare(self, other);
    int expected = 1;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void aboveY() {
    Ex08 test = new Ex08();
    Point self = new Point(0, 1);
    Point other= new Point(0, 0);
    int actual = test.compare(self, other);
    int expected = 1;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void belowX() {
    Ex08 test = new Ex08();
    Point self = new Point(-1, 0);
    Point other= new Point(0, 0);
    int actual = test.compare(self, other);
    int expected = -1;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void belowY() {
    Ex08 test = new Ex08();
    Point self = new Point(0, -1);
    Point other= new Point(0, 0);
    int actual = test.compare(self, other);
    int expected = -1;
    assertThat(actual, is(expected));
  }

}
