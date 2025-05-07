/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Ruba Hassan
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        int port = 20000;
        String host = "127.0.0.1";
        Client client=new Client();
        client.connect(host, port);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        AnchorPane root = loader.load();
        
        // Create a scene with the root AnchorPane
        Scene scene = new Scene(root);
        
        // Set up the stage (window)
        primaryStage.setTitle("Quiz Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launches the JavaFX application
    }

    
}
