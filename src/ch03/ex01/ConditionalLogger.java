package ch03.ex01;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConditionalLogger extends Logger {

  public static void main(String[] args) {
    ConditionalLogger logger = new ConditionalLogger("logger", ConditionalLogger.class.getCanonicalName());
    logger.logIf(Level.WARNING, ()-> true, ()-> "message");
  }
  
  protected ConditionalLogger(String name, String resourceBundleName) {
    super(name, resourceBundleName);
  }
  
  public void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message) {
    if(condition.get() || message != null) {
      this.log(level, message);
    }
  }

}
