package ch04.ex08;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController implements Initializable {
  
  @FXML private Button button;
  @FXML private Label label;
  
  @FXML
  private void onClickButton(ActionEvent e) {
    label.setDisable(true);
  }
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    
  }
  
  
  

}
