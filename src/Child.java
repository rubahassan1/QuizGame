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
import java.util.ArrayList;
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
            while (true) {
                if (!inSocket.hasNextLine()) break;
                String command = inSocket.nextLine();

                if (command.equals("saveScore")) {
                    String username = inSocket.nextLine();
                    String topic = inSocket.nextLine();
                    double score = Double.parseDouble(inSocket.nextLine());
                    saveScore(username, topic, score);
                } else if (command.equals("getTop3")) {
                    String requestedTopic = inSocket.nextLine();
                    ArrayList<String> top = getTop3(requestedTopic);
                    outSocket.println(top.size());
                    for (String name : top) {
                        outSocket.println(name);
                    }
                    outSocket.flush();
                }
            }
            
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
    
    public static ArrayList<String> getTop3(String topic) {
        ArrayList<String> top = new ArrayList<>();
        HashMap<String,Double> topicUsers= topicToUserScores.get(topic);
        for (String user : topicUsers.keySet()){
            top.add(user);
        }
        top.sort((user1, user2) -> Double.compare(topicUsers.get(user2), topicUsers.get(user1)));
        return new ArrayList<>(top.subList(0, Math.min(3, top.size())));
    }

}

