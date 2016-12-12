package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalAsync {

  public static void main(String[] args) {
    
    Supplier<ExceptionThrower> f = new Supplier<ExceptionThrower>() {
      @Override
      public ExceptionThrower get() {
        return new ExceptionThrower();
      }
    };
    
    BiConsumer<ExceptionThrower, Consumer<Throwable>> bi = new BiConsumer<ExceptionThrower, Consumer<Throwable>>() {
      @Override
      public void accept(ExceptionThrower t, Consumer<Throwable> u) {
        try {
          t.doThrowException();
        } catch (Throwable e) {
          u.accept(e);
        }
      }
    };
    
    Consumer<Throwable> handler = new Consumer<Throwable>() {
      @Override
      public void accept(Throwable t) {
        System.out.println("Catch Exception !!");
      }
    };
    
    doInOrderAsync(f, bi, handler);
  }
  
  public static <T> void doInOrderAsync(Supplier<T> doThing,
      BiConsumer<T, Consumer<Throwable>> thenThing, Consumer<Throwable> handler) {
    Thread thread = new Thread() {
      public void run() {
        T result = null;
        try {
          result = doThing.get();
        } catch (Throwable t) {
          handler.accept(t);
        }
        thenThing.accept(result, handler);
      };
    };
    thread.run();
  }
  
  private static class ExceptionThrower {
    public void doThrowException() {
      throw new IllegalAccessError("test");
    }
  }
}
