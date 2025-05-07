/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ruba Hassan
 */
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;


public class Server {
    
    
    
    public static void main(String[] args) {
        try {
            // TODO code application logic
            int port = 20000;

            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("new Connection from" + clientSocket.getRemoteSocketAddress());

                (new Child(clientSocket)).start();
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}

