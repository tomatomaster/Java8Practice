package ch04.ex10;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class WebController implements Initializable {

  @FXML
  private WebView webView;
  @FXML
  private Button button;
  @FXML
  private Button search;
  @FXML
  private TextField textURL;
  private WebEngine engine;

  @FXML
  private void onClick(ActionEvent e) {
    engine.load(textURL.getText());
  }

  @FXML
  private void onBackClick(ActionEvent e) {
    WebHistory history = engine.getHistory();
    engine.load(history.getEntries().get(history.getCurrentIndex() - 1).getUrl());
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    engine = webView.getEngine();
    engine.load("http://google.com");
  }

}
