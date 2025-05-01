/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    @FXML Label error;
    
    String pressed="login";
    
    @FXML TextField username;
    @FXML PasswordField password;
    
    public static String currentUser;
    
    Scanner in=Client.getInput();
    PrintStream out=Client.getOutput();
    
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
    
    
    public void submitUser(ActionEvent event) {
    error.setText("");  // Clear previous error
    String user = username.getText();
    String pass = password.getText();

    // Optional: check for empty fields
    if (user.isEmpty() || pass.isEmpty()) {
        error.setText("Please fill all fields");
        return;
    }

    Task<Void> task = new Task<>() {
        @Override
        protected Void call() {
            try {
                if (pressed.equals("login")) {
                    out.println("login");
                    out.println(user);
                    out.println(pass);
                    out.flush();

                    String result = in.nextLine();
                    if (!result.equals("Valid")) {
                        Platform.runLater(() -> error.setText(result));
                    } else {
                        Platform.runLater(() -> {
                            try {
                                currentUser=username.getText();
                                Parent root = FXMLLoader.load(getClass().getResource("Topics.fxml"));
                                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                stage.setScene(new Scene(root));
                                stage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                } else {
                    out.println("Signup");
                    out.println(user);
                    out.println(pass);
                    out.flush();

                    String result = in.nextLine();
                    if (!result.equals("Done")) {
                        Platform.runLater(() -> error.setText(result));
                    } else {
                        Platform.runLater(() -> {
                            try {
                                currentUser=username.getText();
                                Parent root = FXMLLoader.load(getClass().getResource("Topics.fxml"));
                                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                                stage.setScene(new Scene(root));
                                stage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Platform.runLater(() -> error.setText("Connection failed"));
            }
            return null;
        }
    };

    new Thread(task).start(); // Run task in background
}

    
    
}
