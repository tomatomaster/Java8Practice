package ch09.ex09;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.junit.Test;

public class Ex09Test extends Ex09 {

  @Test
  public void checkReflectivity() {
    LabeledPoint target = new LabeledPoint("label", 0, 0);
    boolean actual = target.equals(target);
    boolean expected = true;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void checkSymmetry() {
    LabeledPoint target = new LabeledPoint("label", 0, 0);
    Point other = new Point(0,0);
    boolean actual = target.equals(other);
    boolean expected = true;
    assertThat(actual, is(expected));
    actual = other.equals(target);
    expected = true;
    assertThat(actual, is(expected));
  }
  
  @Test
  public void checkTransitivity() {
    
  }
  
  @Test
  public void nonNull() {
    LabeledPoint target = new LabeledPoint("test", 0, 0);
    boolean actual = target.equals(null);
    boolean expected = false;
    assertThat(actual, is(expected));
  }

}
