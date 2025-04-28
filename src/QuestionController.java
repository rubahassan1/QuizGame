/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Ruba Hassan
 */
public class QuestionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    String topicName;
    
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
    }    
    
}

