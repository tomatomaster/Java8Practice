package ch03.ex24;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

/**
 * ???
 * @author ono
 *
 */
public class FlatMapTutorial {


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
    
    /**
     * ???できない？
     * @param f
     * @return
     */
    Collection<T> flatMap(Function<T, T> f) {
      Collection<T> c = new ArrayList<T>();
      c.add(f.apply(element1));
      c.add(f.apply(element2));
      return c;
    }

    @Override
    public String toString() {
      return element1 + " " + element2;
    }
  }
}
