
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ruba Hassan
 */
public class LeaderboardController implements Initializable{
    Scanner in=Client.getInput();
    PrintStream out=Client.getOutput();
    
    @FXML
    private Label topic;
    @FXML
    private Label r1;
    @FXML
    private Label r2;
    @FXML
    private Label r3;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String quizTopic = Client.getTopic();
        topic.setText(quizTopic);

        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                try {
                    out.println("getTop3");
                    out.println(quizTopic);
                    out.flush();

                    int topSize = in.nextInt();
                    in.nextLine(); // consume leftover newline

                    ArrayList<String> names = new ArrayList<>();
                    for (int i = 0; i < topSize; i++) {
                        names.add(in.nextLine());
                    }

                    Platform.runLater(() -> {
                        if (topSize >= 1) {
                            r1.setText(names.get(0));
                            r1.setVisible(true);
                        } else {
                            r1.setVisible(false);
                        }

                        if (topSize >= 2) {
                            r2.setText(names.get(1));
                            r2.setVisible(true);
                        } else {
                            r2.setVisible(false);
                        }

                        if (topSize >= 3) {
                            r3.setText(names.get(2));
                            r3.setVisible(true);
                        } else {
                            r3.setVisible(false);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        new Thread(task).start();
    }
    
    public void exit(MouseEvent event) throws IOException, Exception{
        Client.close();
        Platform.exit();
        System.exit(0);
    }

}
