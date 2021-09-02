import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    public ArrayList<Integer> getTenRolls(){
        ArrayList<Integer> getTen= new ArrayList<Integer>();
        Random randMachine = new Random();
        for (int i = 1; i < 10; i++){
            getTen.add(randMachine.nextInt(20) + 1);
        }
        return getTen;
}

public String getLetter(){
    Random randMachine = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String[] alphabetString = new String[26];
    for (int i = 0; i < 26; i++) {
        alphabetString[i] = String.valueOf(alphabet.charAt(i));
    }
    return alphabetString[randMachine.nextInt(26)];
}

public String getPassword(){
    Random randMachine = new Random();
    String password = "";
    for (int i = 0; i < 26; i++) {
        password = password + getLetter();
    }
    return password;
}
public ArrayList<String> newPassword() {

    ArrayList<String> getNewpassword = new ArrayList<String>();
    for(int i = 0; i < 1; i++) {
        getNewpassword.add(getPassword());
    }
    return getNewpassword;

}

}