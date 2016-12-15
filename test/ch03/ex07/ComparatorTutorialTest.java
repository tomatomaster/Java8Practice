package ch03.ex07;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ch03.ex07.ComparatorTutorial.ComparatorOption;

public class ComparatorTutorialTest {

  String sample1 = "ABCD"; 
  String sample2 = "BCDE";
  Set<ComparatorOption> options = new HashSet<ComparatorOption>();
  ComparatorTutorial comp = new ComparatorTutorial();
  
  @Test
  public void オプションなし() {
    int actual = comp.getNaturalComparator(options).compare(sample1, sample2);
    assertTrue(actual < 0);
  }
  
  public void 逆順オプションあり(){
    options.add(ComparatorOption.REVERSE);
    int actual = comp.getNaturalComparator(options).compare(sample1, sample2);
    assertTrue(actual > 0);
  }
  
  public void 同じ値のテスト() {
    int actual = comp.getNaturalComparator(options).compare(sample1, sample1);
    assertThat(actual, is(0));
  }

}
