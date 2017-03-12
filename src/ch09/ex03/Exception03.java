package ch09.ex03;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;

/**
 * 
 * 
 *
 */
public class Exception03 {
  
  public void test() throws UnknownHostException, FileNotFoundException {
    try {
      throwExceptionA();
      throwExceptionB();
    } catch (UnknownHostException | FileNotFoundException e) {
      throw e;
    }
    
  }
  
  public void throwExceptionA() throws UnknownHostException {
    throw new UnknownHostException();
  }

  public void throwExceptionB() throws FileNotFoundException {
    throw new FileNotFoundException();
  }
  
}


