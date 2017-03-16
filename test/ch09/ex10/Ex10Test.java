package ch09.ex10;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Test;

public class Ex10Test extends Ex10 {

  @Test
  public void same() {
    LabeledPoint a = new LabeledPoint("test", 0, 0);
    Map<LabeledPoint.Result, Integer> actual = a.compareTo(a);
    actual.values().stream().forEach(val -> assertThat(val, is(0)));
  }
  
  @Test
  public void notSame() {
    LabeledPoint a = new LabeledPoint("test", 0, 0);
    LabeledPoint b = new LabeledPoint("test", 1, 0);
    Map<LabeledPoint.Result, Integer> actual = a.compareTo(b);
    actual.forEach((key, val) -> {
      if(key == LabeledPoint.Result.x) {
        assertThat(val, is(-1));
      } else {
        assertThat(val, is(0));
      }
    });
  }
  
  @Test
  public void notSameLabel() {
    LabeledPoint a = new LabeledPoint("abcd", 0, 0);
    LabeledPoint b = new LabeledPoint("acde", 0, 0);
    Map<LabeledPoint.Result, Integer> actual = a.compareTo(b);
    actual.forEach((key, val) -> {
      if(key == LabeledPoint.Result.label) {
        assertThat(val, is(-1));
      } else {
        assertThat(val, is(0));
      }
    });
  }
  
  @Test
  public void notSamePoint() {
    LabeledPoint a = new LabeledPoint("abcd", 1, 0);
    LabeledPoint b = new LabeledPoint("abcd", 0, 1);
    Map<LabeledPoint.Result, Integer> actual = a.compareTo(b);
    actual.forEach((key, val) -> {
      if(key == LabeledPoint.Result.x) {
        assertThat(val, is(1));
      } else if(key == LabeledPoint.Result.y) {
        assertThat(val, is(-1));
      }  else {
        assertThat(val, is(0));
      }
    });
  }
  
}
