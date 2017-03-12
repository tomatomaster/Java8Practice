package ch09.ex10;

import java.util.Objects;

public class Ex10 {
  
  public static void main(String[] args) {
    LabeledPoint lp1 = new LabeledPoint("test", 10, 20);
    LabeledPoint lp2 = new LabeledPoint("test", 15, 22);
    lp1.compareTo(lp2).showResult();
  }

  public static class LabeledPoint {
    private String label;
    private int x;
    private int y;

    public LabeledPoint(String label, int x, int y) {
      this.label = label;
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(label, x, y);
    }

    public Result compareTo(LabeledPoint other) {
      int diffX = Integer.compare(x, other.x);
      int diffY = Integer.compare(y, other.y);
      int diffS = label.compareTo(other.label);
      return new LabeledPoint.Result(diffX, diffY, diffS);
    }

    private static class Result {
      final int diffX;
      final int diffY;
      final int diffS;

      public Result(int diffX, int diffY, int diffS) {
        this.diffX = diffX;
        this.diffY = diffY;
        this.diffS = diffS;
      }
      
      public void showResult() {
        System.out.printf("%d %d %d", diffX, diffY,diffS);
      }
    }
  }
}
