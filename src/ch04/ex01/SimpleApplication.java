package ch04.ex01;

import java.util.Objects;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SimpleApplication extends Application {

  private static int fontSize = 100;
  private final Model model = new Model();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {

    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 1000, 150);
    stage.setScene(scene);
    stage.setTitle("Hello");

    Label message = new Label("Bind JavaFx");
    message.setFont(new Font(fontSize));
    message.textProperty().bind(model.valueProperty());

    TextField textField = new TextField();
    model.valueProperty.bind(textField.textProperty());


    pane.setTop(message);
    pane.setBottom(textField);

    stage.show();
  }

  private static class Model {

    private StringProperty valueProperty = null;
    private String value;

    public StringProperty valueProperty() {
      if (Objects.isNull(valueProperty)) {
        valueProperty = new SimpleStringProperty(value);
      }
      return valueProperty;
    }
  }

}
