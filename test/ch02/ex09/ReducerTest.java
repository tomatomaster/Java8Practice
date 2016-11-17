package ch02.ex09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class ReducerTest {

  Stream<ArrayList<String>> stream;
  
  @Before
  public void setUp() {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("yaruki");
    arrayList.add("genki");
    stream = Stream.of(arrayList);
  }
  
  @Test
  public void testReducer1() {
    ArrayList<String> actual = Reducer.reducer1(stream);
    ArrayList<String> expected = new ArrayList<String>(Arrays.asList("yaruki","genki"));
    assertEquals(expected, actual);
  }

  @Test
  public void testReducer2() {
    ArrayList<String> actual = Reducer.reducer2(stream);
    ArrayList<String> expected = new ArrayList<String>(Arrays.asList("ETERNAL","yaruki","genki"));
    assertEquals(expected, actual);
  }

  @Test
  public void testReducer3() {
    ArrayList<String> actual = Reducer.reducer3(stream);
    ArrayList<String> expected = new ArrayList<String>(Arrays.asList("ETERNAL","yaruki","genki"));
    assertEquals(expected, actual);
  }

}
