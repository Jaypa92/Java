public class TestAccount{
public static void main(String[] arge){
    BankAccount account1 = new BankAccount();
    BankAccount account2 = new BankAccount();

    System.out.println(account1.checkChecking());
    System.out.println(account1.checkSavings());

    account1.addToChecking(1000);
    account2.addToSavings(4000);

    System.out.println(BankAccount.totalAmount);
    System.out.println(BankAccount.numberOfAccounts);

    account2.withDraw(1000);
    account2.addToChecking(2000);
    System.out.println(account2.displayAccTotal());
}
}