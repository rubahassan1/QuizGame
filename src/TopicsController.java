/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ruba Hassan
 */
public class TopicsController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
private Label Mathematics;

@FXML
private Label Science;

@FXML
private Label History;

@FXML
private Label Geography;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Mathematics.setOnMouseClicked(event ->{Client.setTopic("Mathematics"); goToQuestionPage(Mathematics.getText());});
        Science.setOnMouseClicked(event -> {Client.setTopic("Science"); goToQuestionPage(Science.getText());});
        History.setOnMouseClicked(event -> {Client.setTopic("History"); goToQuestionPage(History.getText());});
        Geography.setOnMouseClicked(event -> {Client.setTopic("Science"); goToQuestionPage(Geography.getText());});
    }    
    
    public void goToQuestionPage(String topicName){
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Questions.fxml"));
        
        // Pass the topicName directly to the controller constructor
        loader.setController(new QuestionController(topicName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) Mathematics.getScene().getWindow();
        stage.setScene(scene);
        
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
}
