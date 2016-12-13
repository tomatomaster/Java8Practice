package ch04.ex03;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class SimpleApplication extends Application {

  @Override
  public void start(Stage arg0) throws Exception {}

  public class Greeting {

    private volatile StringProperty text;
    private static final String DEFAULT = "default";

    public final StringProperty textProperty() {
      if(text == null) 
        text = new SimpleStringProperty(DEFAULT);
      return text;
    }

    public final void setText(String newValue) {
      if (DEFAULT.equals(newValue))
        return;
      if (text == null) {
        text = new SimpleStringProperty(newValue);
        return;
      }
      text.set(newValue);
    }

    public final String getText() {
      if (text == null)
        return DEFAULT;
      return text.get();
    }
  }

}
