package ch04.ex10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebBrowser extends Application {
  
  private Scene scene;

  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle("Mozaic");
    Parent root = FXMLLoader.load(getClass().getResource("Web.fxml"));
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  
  class Browser extends Region {
    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    
    private TextArea urlBar = new TextArea("http://google.com"); 
    
    public Browser() {
      getStyleClass().add("browser");
      webEngine.load("http://google.com");
      getChildren().add(browser);
      getChildren().add(urlBar);
    }
    
  }
  
  
  

}
