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
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Child extends Thread {
    public static HashMap<String, String> users=new HashMap<>();
    public static HashMap<String, HashMap<String, Double>> topicToUserScores = new HashMap<>();   // <topic,<username,score>>
    
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
            while (true) {
                String response;
                if (!inSocket.hasNextLine()) break;
                response = inSocket.nextLine();

                if (response.equals("login")) {
                    String username = inSocket.nextLine();
                    String password = inSocket.nextLine();
                    String result = checkUser(username, password);
                    outSocket.println(result);
                    outSocket.flush();

                    if (result.equals("Valid")) break; // exit loop after success
                } else if (response.equals("Signup")) {
                    String username = inSocket.nextLine();
                    String password = inSocket.nextLine();
                    String result = addUser(username, password);
                    outSocket.println(result);
                    outSocket.flush();

                    if (result.equals("Done")) break; // exit loop after success
                }
            }
            String username=inSocket.nextLine();
            String topic=inSocket.nextLine();
            double score=inSocket.nextDouble();
            saveScore(username,topic,score);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static String checkUser(String username, String password){
        //if username not found return User not found
        // if password incorrect return incorrect password
        if (users.containsKey(username)) {
            if (!users.get(username).equals(password)){
                // Success: proceed to next scene
                return "Incorrect Password";
            }
        } else {
            return "Username does not exist!";
        }
        return "Valid";
    }
    
    public static String addUser(String username, String password){
        if(users.containsKey(username)){
            return "Username Already Exists!";
        }
        else{
            users.put(username, password);
            return "Done";
        }
    }
    
    public static void saveScore(String username, String topic, double score){
        System.out.println(username);        
        System.out.println(topic);
        System.out.println(score);
        HashMap<String,Double> usersScore=topicToUserScores.get(topic);
        if(usersScore!=null)
            usersScore.put(username,score);
        else{
            usersScore=new HashMap<>();
            usersScore.put(username,score);
        }
        topicToUserScores.put(topic,usersScore);
    }
    
//    public static List<String[]> getTop3(String topic) {
//        
//    }

}

