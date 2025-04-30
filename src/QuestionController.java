/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 * FXML Controller class
 *
 * @author Ruba Hassan
 */
public class QuestionController implements Initializable {
    @FXML
    private Label timerLabel;

    private Timeline timer;
    private int timeRemaining = 30;
    
    @FXML
    private Label question;
    
    @FXML
    private Label op1;
    
    @FXML
    private Label op2;
    
    @FXML
    private Label op3;
    
    @FXML
    private Label op4;
    
    @FXML
    private Button next;
            
    /**
     * Initializes the controller class.
     */
    String topicName;
    int index;
    int topic;
    int selectedOption=0;
    private Stage stage;
    private Scene scene;
    private Parent root;
    ArrayList<Object> answers=new ArrayList<>();
    Object[][] topics = {
            {"Mathematics", 
                new String[][] {
                    {"What is the derivative of x²?", "2x", "x²", "2x²", "x", "2x"},
                    {"What is the value of Pi up to two decimal places?", "3.14", "3.15", "3.13", "3.16", "3.14"},
                    {"What is the integral of 3x?", "3x²", "x³", "3x³", "1.5x²", "1.5x²"},
                    {"If the area of a circle is 78.5 square units, what is its radius?", "5", "7", "10", "6", "5"}
                }
            },
            {"Science", 
                new String[][] {
                    {"What is the chemical symbol for water?", "H2O", "O2", "CO2", "H2", "H2O"},
                    {"What planet is known as the Red Planet?", "Earth", "Venus", "Mars", "Jupiter", "Mars"},
                    {"What gas do plants absorb from the atmosphere?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen", "Carbon Dioxide"},
                    {"What is the boiling point of water?", "90°C", "100°C", "110°C", "120°C", "100°C"},
                    {"What is the hardest known natural material?", "Gold", "Iron", "Diamond", "Platinum", "Diamond"}
                }
            },
            {"History", 
                new String[][] {
                    {"Who was the first president of the United States?", "George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams", "George Washington"},
                    {"In which year did World War II end?", "1940", "1945", "1950", "1960", "1945"},
                    {"Who was the first emperor of China?", "Qin Shi Huang", "Han Wudi", "Li Shimin", "Emperor Gaozu", "Qin Shi Huang"},
                    {"Who discovered America in 1492?", "Christopher Columbus", "Ferdinand Magellan", "Marco Polo", "Leif Erikson", "Christopher Columbus"},
                    {"What year did the Titanic sink?", "1912", "1909", "1898", "1920", "1912"}
                }
            },
            {"Geography", 
                new String[][] {
                    {"What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "Paris"},
                    {"Which country is known as the Land of the Rising Sun?", "China", "Japan", "India", "South Korea", "Japan"},
                    {"Which is the largest continent?", "Asia", "Africa", "North America", "Europe", "Asia"},
                    {"What is the longest river in the world?", "Amazon", "Nile", "Yangtze", "Mississippi", "Nile"},
                    {"What is the capital of Japan?", "Beijing", "Tokyo", "Seoul", "Kyoto", "Tokyo"}
                }
            }
        };
    
    public QuestionController(String topicName) {
        this.topicName = topicName;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("Initialized with topic "+topicName);
        setupQuestion();
        question.setWrapText(true);
        setupOptionClicks();
    }
    
    public void setupQuestion() {
    if ("Science".equals(topicName)) topic = 1;
    if ("History".equals(topicName)) topic = 2;
    if ("Geography".equals(topicName)) topic = 3;

    question.setText((index + 1) + ". " + ((String[][])topics[topic][1])[index][0]);
    op1.setText(((String[][])topics[topic][1])[index][1]);
    op2.setText(((String[][])topics[topic][1])[index][2]);
    op3.setText(((String[][])topics[topic][1])[index][3]);
    op4.setText(((String[][])topics[topic][1])[index][4]);
    if(index==((String[][])topics[topic][1]).length-1){
        next.setText("Finish");
    }
    startTimer();
}
    
    public void goToNext(){
        answers.add(new Object[] {selectedOption, 30 - timeRemaining});
        try {
            if (index < ((String[][]) topics[topic][1]).length - 1) {
                index++;
                setupQuestion();
            } else {
                calculateScore();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Score.fxml"));
        
        // Pass the topicName directly to the controller constructor
        loader.setController(new ScoreController(score));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) question.getScene().getWindow();
        stage.setScene(scene);
            }
            op1.setStyle("");
            op2.setStyle("");
            op3.setStyle("");
            op4.setStyle("");
            selectedOption = 0;
        } catch (IOException e) {
            e.printStackTrace(); // Or handle the error properly with a popup
        }
        setupQuestion();
        op1.setStyle("");
        op2.setStyle("");
        op3.setStyle("");
        op4.setStyle("");
        selectedOption=0;
    }
    
    private void setupOptionClicks() {
    op1.setOnMouseClicked(e -> selectOption(op1));
    op2.setOnMouseClicked(e -> selectOption(op2));
    op3.setOnMouseClicked(e -> selectOption(op3));
    op4.setOnMouseClicked(e -> selectOption(op4));
    }
    
    public void selectOption(Label selected) {
    // Reset style for all options
    op1.setStyle("");
    op2.setStyle("");
    op3.setStyle("");
    op4.setStyle("");

    // Apply selected style
    selected.setStyle("-fx-background-color: rgba(135, 206, 250, 0.5);");
    
    // Store selected option index
    if (selected == op1) selectedOption = 1;
    else if (selected == op2) selectedOption = 2;
    else if (selected == op3) selectedOption = 3;
    else if (selected == op4) selectedOption = 4;
    }
    
    private void startTimer() {
    if (timer != null) {
        timer.stop(); // Reset if already running
    }

    timeRemaining = 30;
    timerLabel.setText("00:" + (timeRemaining < 10 ? "0" + timeRemaining : timeRemaining));

    timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
        timeRemaining--;
        timerLabel.setText("00:" + (timeRemaining < 10 ? "0" + timeRemaining : timeRemaining));

        if (timeRemaining <= 0) {
            timer.stop();
            goToNext(); // Or disable options
        }
    }));
    timer.setCycleCount(timeRemaining);
    timer.play();
}
    double score=0;
    private void calculateScore() {
    for (int i = 0; i < answers.size(); i++) {
        Object[] answer = (Object[]) answers.get(i);
        int selectedOption = (int) answer[0];
        int timeTaken = (int) answer[1];

        // Retrieve the correct answer for the current question
        String[][] currentTopic = (String[][]) topics[topic][1];
        String correctAnswer = currentTopic[i][5];  // Correct answer is stored at index 5 (assuming 1-indexed options)

        // Check if the selected answer is correct
        if (selectedOption > 0 && selectedOption < 5 && currentTopic[i][selectedOption].equals(correctAnswer)) {
            // The answer is correct, so add points (e.g., 10 points)
            int questionScore = 10;

            // Optionally, deduct points based on timeTaken (e.g., 1 point deducted for each second taken)
            int timePenalty = timeTaken > 20 ? (timeTaken - 20) : 0;
            questionScore = Math.max(0, questionScore - timePenalty);

            // Accumulate score for each question
            score += questionScore;
        }
    }
    // Print the total score
    System.out.println("Total Score: " + score);
}

}

