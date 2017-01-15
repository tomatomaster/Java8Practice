package ch06.ex04;

import java.util.concurrent.atomic.LongAccumulator;

public class Ex04 {

  LongAccumulator longAccumulator = new LongAccumulator(Math::max, 0);
  
  public static void main(String[] args) {
    Ex04 ex = new Ex04();
    ex.longAccumulator.
  }

  public long getMax() {
    longAccumulator.accumulate(longAccumulator.get());
    return longAccumulator.get();
  }
}
