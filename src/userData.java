public class userData {
    private String username;
    private String password;
    private double Score [];
    boolean taken = false;
 public userData(String username, String password){
    this.username = username;
    this.password = password;
 }   
 public String getUsername(){
    return username;
 }
 public String getPassword(){
    return password;
 }
 public double [] getScore(){
    return Score;
 }
 public double ScoreOfTopic(int topic){
    return Score[topic];
 }
public String setScore(int topic, double scores){
    if (taken) {
        return "Quiz already taken, can't add score";
    }
    taken = true;
    Score [topic] = scores;
    return "Score added to user data";
}

}
