import java.util.Random;
import java.util.ArrayList;

public class PuzzleTest {
    public static void main(String[] args){
        
        PuzzleJava puzzleJava = new PuzzleJava();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        puzzleJava.getTenRolls(nums);
        System.out.println(nums);

        System.out.println(puzzleJava.getRandomLetter());
        System.out.println(puzzleJava.generatePassword());
        int length = 4;
        System.out.println(puzzleJava.getNewPasswordSet(length));
}
}