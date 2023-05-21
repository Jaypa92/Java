import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil{
    public int getStreakGoal(){
        int sum = 0;
        for(int i = 0;i<=10;i++){
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double sum = 0;
        for(double num:prices){
           sum += num;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menu){
        for(int i = 0;i< menu.size();i++){
            System.out.println(i + " " + menu.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String name = System.console().readLine();
        System.out.println("Hello" + name);
        System.out.println("There are" +" "+customers.size() + " customer(s) in front of you");
        customers.add(name);
    }
}