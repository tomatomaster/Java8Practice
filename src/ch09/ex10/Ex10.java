package ch09.ex10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Ex10 {
  
  public static void main(String[] args) {
    LabeledPoint lp1 = new LabeledPoint("test", 10, 20);
    LabeledPoint lp2 = new LabeledPoint("test", 15, 22);
    lp1.compareTo(lp2).forEach( (key, val)-> {
     System.out.printf("CompareTo:%s result:%s\n", key, val);
    });
  }

  public static class LabeledPoint {
    private String label;
    private int x;
    private int y;
    enum Result {
      x,
      y,
      label
    }

    public LabeledPoint(String label, int x, int y) {
      this.label = label;
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(label, x, y);
    }

    public Map<Result, Integer> compareTo(LabeledPoint other) {
      Map<Result, Integer> result = new HashMap<>();
      int diffX = Integer.compare(x, other.x);
      int diffY = Integer.compare(y, other.y);
      int diffS = label.compareTo(other.label);
      result.put(Result.x, diffX);
      result.put(Result.y, diffY);
      result.put(Result.label, diffS);
      return result;
    }
  }
}
