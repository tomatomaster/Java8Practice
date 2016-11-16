package ch02.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneLinerTest {

  static final String TESTSTRING = "test";
  Character[] charArray = {'t','e','s','t'};
  
  @Test
  public void testCharacterStream() {
    assertEquals(charArray, OneLiner.characterStream(TESTSTRING).toArray(Character[]::new));
  }

}
