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
public class ScoreController implements Initializable {
    @FXML
    private Label scoreValue;
    double score;
    /**
     * Initializes the controller class.
     */

    public ScoreController(double score){
        this.score=score;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setScore();
    }   
    
    public void setScore(){
        scoreValue.setText(score+" / 100");
    }
    
}
