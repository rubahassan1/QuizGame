/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ruba Hassan
 */
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String topic;
    private static Socket mysocket;
    private static Scanner in;
    private static PrintStream out;
    int port = 20000;
    String host = "127.0.0.1";

    public void connect(String host, int port) throws Exception {
        mysocket = new Socket(host, port);
        in = new Scanner(mysocket.getInputStream());
        out = new PrintStream(mysocket.getOutputStream());
    }
    
    public static Scanner getInput() {
        return in;
    }

    public static PrintStream getOutput() {
        return out;
    }
    
    public static void setTopic(String myTopic){
        topic = myTopic;
    }
    
    public static String getTopic(){
        return topic;
    }

    public static void close() throws Exception {
        mysocket.close();
    }
}
