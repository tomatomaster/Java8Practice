package ch03.ex23;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch03.ex23.MapTuttorial.Pair;

public class MapTuttorialTest {

  @Test
  public void 対となる文字列にprefixを追加するテスト() {
    Pair<String> pair = new Pair<String>("Test1", "Test2");
    pair.map((string) -> {return "prefix-" + string;});
    boolean result = pair.toString().contains("prefix-");
    assertTrue(result);
  }

}
