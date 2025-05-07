/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    
    public void viewRanking(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Leaderboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    public void exit(MouseEvent event) throws IOException, Exception{
        Client.close();
        Platform.exit();
        System.exit(0);
    }
    
}
