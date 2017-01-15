package ch06.ex03;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Ex03 {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    new Ex03().test1(1000, 100000);
    long end1  = System.currentTimeMillis();
    System.out.println("AtomicLong#incrementAndGet " + (end1 - start) + " millSec");
    new Ex03().test2(1000, 100000);
    long end2 = System.currentTimeMillis();
    System.out.println("LongAdder#increment " + (end2 - end1) + " millSec");
  }
  
  public void test1(int nThreadnum, int nIncrement) {
    AtomicLong atomicLong = new AtomicLong();
    for(int i=0; i < nThreadnum; i++) {
      new Thread(()-> {
        for(int j=0; j<nIncrement; j++) {
          atomicLong.incrementAndGet();  
        }
      }).run();
    }
  }
  
  public void test2(int nThreadnum, int nIncrement) {
    LongAdder longAdder = new LongAdder();
    for(int i=0; i < nThreadnum; i++) {
      new Thread(()-> {
        for(int j=0; j<nIncrement; j++) {
          longAdder.increment();
        }
      }).run();
    }
  }
}
