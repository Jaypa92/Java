public class TestOrders {
    public static void main(String[] args){
        CoffeKiosk coffeeKiosk = new CoffeKiosk();

        coffeeKiosk.addMenuItem("Orange",1.25);
        coffeeKiosk.addMenuItem("Coffee", 2.25);
        coffeeKiosk.addMenuItem("Brownie", 2.10);

        coffeeKiosk.newOrder();
    }
}