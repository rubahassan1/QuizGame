/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Ruba Hassan
 */
public class FXMLController implements Initializable {

    @FXML
    private Button helloButton;

    @FXML
private Label helloText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization code, if needed
    }

    @FXML
    private void sayHello(ActionEvent event) {
        helloText.setText("Hello!"); // Updates label text when button is clicked
    }
}

