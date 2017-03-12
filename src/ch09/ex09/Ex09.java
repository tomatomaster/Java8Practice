package ch09.ex09;

import java.util.Objects;

public class Ex09 {
  
  public static void main(String[] args) {
    LabeledPoint lp = new LabeledPoint("test", 10, 20);
    System.out.println(lp.hashCode());
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
  }
}

