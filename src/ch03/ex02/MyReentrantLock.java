package ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock extends ReentrantLock {
  
  public static void main(String[] args) {
    MyReentrantLock myReentntrantLock = new MyReentrantLock();

    myReentntrantLock.withLock(new ReentrantLock(), () -> {
      System.out.println("Something to do");
    });
  }

  public void withLock(ReentrantLock myLock, Runnable action) {
    myLock.lock();
    try {
      action.run();
    } finally {
      myLock.unlock();
    }
  }
}
