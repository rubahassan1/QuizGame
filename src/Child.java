/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ruba Hassan
 */
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Child extends Thread {
    Socket clientSocket;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public Child(Socket socket) {
        this.clientSocket = socket;
        this.stage = stage;
    }

    

    public void run() {

        try {
            Scanner inSocket = new Scanner(clientSocket.getInputStream());
            PrintStream outSocket = new PrintStream(clientSocket.getOutputStream());
            outSocket.println("LOAD_TOPICS");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

