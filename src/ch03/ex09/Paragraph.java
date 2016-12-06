package ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;



public class Paragraph {

  public static void main(String[] args) {
    int result = lexicographicComparator("field1", "field2").compare(Class1.class, Class2.class);
    System.out.println(result);
  }

  public static Comparator<Class<?>> lexicographicComparator(String... fieldName) {
    return new Comparator<Class<?>>() {
      @Override
      public int compare(Class<?> clazz1, Class<?> clazz2) {
        int difference = 0;
        for (final String filed : fieldName) {
          try {
            Field value1 = clazz1.getField(filed);
            Field value2 = clazz2.getField(filed);
            //TODO 
            System.out.println(value1);
            System.out.println(value2);
            if (!value1.equals(value2))
              difference++;
          } catch (NoSuchFieldException e) {
            difference++;
          } catch (Exception e) {
            System.out.println(e);
          }
        }
        return difference;
      }
    };
  }

  public class Class1 {
    public int field1 = 1;
    public int field2 = 2;
  }

  public class Class2 {
    public int field1 = 1;
    public int field2 = 2;
  }
}


