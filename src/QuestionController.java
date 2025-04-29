/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;



/**
 * FXML Controller class
 *
 * @author Ruba Hassan
 */
public class QuestionController implements Initializable {
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
            
    /**
     * Initializes the controller class.
     */
    String topicName;
    int index;
    int topic;
    int selectedOption=0;
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
}
    
    public void goToNext(){
        if(selectedOption!=0){
        if(index<((String[][])topics[topic][1]).length-1)
            index++;
        else
            index=0;
        setupQuestion();
        op1.setStyle("");
        op2.setStyle("");
        op3.setStyle("");
        op4.setStyle("");
        selectedOption=0;
        }
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
    
}

