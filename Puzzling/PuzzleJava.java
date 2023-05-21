import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

public void getTenRolls(ArrayList<Integer> nums){
Random random = new Random();
for(int i = 0;i <10;i++){
    int x = random.nextInt(20)+1;
    nums.add(x);
}
}
public String getRandomLetter(){
    String [] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    Random random = new Random();
    int x = random.nextInt(26);
    return letters[x];
}
public String generatePassword(){
    ArrayList<String> pass = new ArrayList<String>();
    for(int i = 0;i<8;i++){
        pass.add(getRandomLetter());
    }
    return String.join("",pass);
}

public String getNewPasswordSet(int length){
    ArrayList<String> newPass = new ArrayList<String>();
    for(int i = 0;i<length;i++){
        newPass.add(generatePassword());
    }
    return String.join("",newPass);
}
}