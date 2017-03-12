package ch09.ex11;

import java.io.IOException;

public class Ex11 {

  public static void main(String[] args) {
    try {
      new Ex11().writeCardInfo();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void writeCardInfo () throws IOException {
    String home = System.getProperty("user.home");
    String grepRecursively = "grep -r -o";
    String pattern = "'[0-9]\\{4\\}-[0-9]\\{4\\}-[0-9]\\{4\\}-[0-9]\\{4\\}'";
    String target = home + "/*"; 
    String to = home + "/log.log";
    StringBuilder sb = new StringBuilder();
    sb.append(grepRecursively).append(" ").append(pattern).append(" ").append(target);
    exec(sb.toString());
  }
  
  private void exec(String command) throws IOException {
    ProcessBuilder builder = new ProcessBuilder("/bin/sh", "-c", command);
    builder.inheritIO();
    builder.start();
  }
}
