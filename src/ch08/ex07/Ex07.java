package ch08.ex07;

import java.util.Arrays;

public class Ex07 {
  public static void main(String[] args) {
    Person[] people =
        {new Person("e"), new Person("a"), new Person("tt"), new Person("e"), new Person("ez")};
    Arrays.sort(people, java.util.Comparator.comparing(Person::getMiddleName,
        java.util.Comparator.nullsFirst(java.util.Comparator.reverseOrder())));
    for(Person p: people) {
      System.out.println(p.getMiddleName());
    }
  }

  private static class Person {
    String middleName = "";

    public Person(String middleName) {
      this.middleName = middleName;
    }

    String getMiddleName() {
      return middleName;
    }
  }
}
