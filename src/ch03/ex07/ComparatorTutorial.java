package ch03.ex07;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ComparatorTutorial {

  public static void main(String[] args) {
    String sample1 = "It is fine"; 
    String sample2 = "It is rainny";
    Set<ComparatorOption> options = new HashSet<ComparatorOption>();
    ComparatorTutorial comp = new ComparatorTutorial();
    //Normal
    int result1 = comp.getNaturalComparator(options).compare(sample1, sample2);
    //Reverse
    options.add(ComparatorOption.REVERSE);
    int result2 = comp.getNaturalComparator(options).compare(sample1, sample2);
    //Same
    int result3 = comp.getNaturalComparator(options).compare(sample1, sample1);
    System.out.printf("result1 = %d result2 = %d result3 = %d", result1, result2, result3);
  }
  
  public Comparator<String> getNaturalComparator(Set<ComparatorOption> options) {
    return new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int result;
        int reverse = 1;
        if(options.contains(ComparatorOption.REVERSE))
          reverse = -1;
        if(options.contains(ComparatorOption.BLANK)) {
          o1.replace(" ", "").replace("　", "");
          o2.replace(" ", "").replace("　", "");
        }
        if(options.contains(ComparatorOption.LOWER)) {
          result = o1.compareToIgnoreCase(o2);
        } else {
          result = o1.compareTo(o2);  
        }
        return reverse*result;
      }
    };
  }
  
  enum ComparatorOption {
    REVERSE,
    LOWER,
    BLANK,
  }
}
