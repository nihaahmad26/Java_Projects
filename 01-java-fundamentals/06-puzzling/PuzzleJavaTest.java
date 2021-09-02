import java.util.ArrayList;
import java.util.Random;
public class PuzzleJavaTest {
    public static void main(String[] args){
        PuzzleJava puzzleJava = new PuzzleJava();
        ArrayList<Integer> randomRolls = puzzleJava.getTenRolls();
System.out.println(randomRolls);
System.out.println(puzzleJava.getLetter());
System.out.println(puzzleJava.getPassword());
System.out.println(puzzleJava.newPassword());
}
}
