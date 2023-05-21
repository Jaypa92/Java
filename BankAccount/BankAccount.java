public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    public static int numberOfAccounts = 0;
    public static double totalAmount = 0;

    public BankAccount(){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
    }

    public double checkChecking(){
        return this.checkingBalance;
    }

    public double checkSavings(){
        return this.savingsBalance;
    }

    public void addToChecking(double num){
        this.checkingBalance += num;
        totalAmount += num;
    }

    public void addToSavings(double num){
        this.savingsBalance += num;
        totalAmount += num;
    }

    public void withDraw(double amt){
        if(this.checkingBalance >= amt){
            this.checkingBalance -= amt;
            totalAmount -= amt;
        }
    }

    public double displayAccTotal(){
        return this.checkingBalance + this.savingsBalance;
    }
}