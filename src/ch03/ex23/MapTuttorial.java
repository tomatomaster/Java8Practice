package ch03.ex23;

import java.util.function.Function;

public class MapTuttorial {


  public static class Pair<T> {
    private T element1;
    private T element2;
    
    public Pair(T element1, T element2) {
      this.element1 = element1;
      this.element2 = element2;
    }
    
    Pair<T> map(Function<T, T> function) {
      element1 = function.apply(element1);
      element2 = function.apply(element2);
      return new Pair<T>(element1, element2);
    }
    
    @Override
    public String toString() {
      return element1 + " " + element2;
    }
  }
}
