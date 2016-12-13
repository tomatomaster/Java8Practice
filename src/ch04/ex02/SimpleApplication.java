package ch04.ex02;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class SimpleApplication extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
	}

	public class Greeting {

		private volatile StringProperty text;
		private String tempText;

		public final StringProperty textProperty() {
			if (text.isNull().getValue()) {
				text = new SimpleStringProperty(tempText);
			}
			return text;
		}

		public final void setText(String newValue) {
			if (text.isNull().getValue())
				tempText = newValue;
			text.set(newValue);
		}

		public final String getText() {
			if (text.isNull().getValue())
				return tempText;
			return text.get();
		}
	}

}
