package ch09.ex09;

import java.awt.Point;
import java.util.Objects;

public class Ex09 {

  public static void main(String[] args) {
    LabeledPoint lp = new LabeledPoint("test", 10, 20);
    System.out.println(lp.hashCode());
  }

  public static class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, int x, int y) {
      this.label = label;
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(label, x, y);
    }

    @Override
    public boolean equals(Object obj) {

      
      if(obj instanceof LabeledPoint) {
        return Objects.nonNull(obj) && this.label.equals(((LabeledPoint) obj).getLabel());
      } else {
        return Objects.nonNull(obj) && super.equals(this);
      }
    }

    public String getLabel() {
      return label;
    }
  }
}

