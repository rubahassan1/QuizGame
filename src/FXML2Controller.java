/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

/**
 * FXML Controller class
 *
 * @author Ruba Hassan
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class FXML2Controller implements Initializable{
    
    @FXML
    private Label error;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void startButtonClicked(ActionEvent event) throws IOException {
          try{
            int port = 20000;
            String host = "127.0.0.1";
            Socket mySocket = new Socket(host, port);
            Scanner key = new Scanner(System.in);
            PrintStream outSocket = new PrintStream(mySocket.getOutputStream());
            Scanner inSocket=new Scanner(mySocket.getInputStream());
            outSocket.println("username");

            String response = inSocket.nextLine();
            if (response.equals("LOAD_TOPICS")){
                Parent root = FXMLLoader.load(getClass().getResource("Topics.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }
            else{
                error.setText("Username already exists!");
            }
          
          } catch (IOException ex) {
            System.out.println(ex);
          }
    }
}

