/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Ruba Hassan
 */
public class LoginController implements Initializable {
    @FXML 
    private Button login;
    @FXML 
    private Button signup;
    String pressed="login";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        login.getStyleClass().add("button-pressed");
        signup.getStyleClass().add("button-default");
    }  
    
    public void pressBtn(javafx.scene.input.MouseEvent event){
        if (event.getSource() == login) {
            pressed = "login";
            login.getStyleClass().setAll("button-pressed");
            signup.getStyleClass().setAll("button-default");
        } else if (event.getSource() == signup) {
            pressed = "signup";
            signup.getStyleClass().setAll("button-pressed");
            login.getStyleClass().setAll("button-default");
        }
    }
    
}
