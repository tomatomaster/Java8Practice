package ch03.ex18;

import java.util.function.Function;

public class Unchecked {

  public static <T, U> Function<T, U> unchecked(ThrowExceptionInterface<T, U> f) {
    return (param) -> {
      try {
        return f.apply(param);
      } catch (Exception e) {
        throw new RuntimeException(e);
      } catch (Throwable t) {
        throw t;
      }
    };
  }
  
  @FunctionalInterface
  interface ThrowExceptionInterface<T, U> {
    public U apply(T t) throws Exception;
  }
}
