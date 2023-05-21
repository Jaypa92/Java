public class TestOrders {
    public static void main(String[] args){
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Tim");
        Order order4 = new Order("Ronnie");
        Order order5 = new Order("Joe");

        Item item1 = new Item("Coffe",3.50);
        Item item2 = new Item("Latte",4.50);
        Item item3 = new Item("Capuccino",5.25);
        Item item4 = new Item("Mocha",4.99);

    order1.addItem(item1);
    order1.addItem(item2);
    order2.addItem(item3);
    order2.addItem(item4);
    order3.addItem(item1);
    order3.addItem(item3);
    order4.addItem(item2);
    order4.addItem(item4);
    order5.addItem(item1);
    order5.addItem(item4);

    order1.setReady(true);
    System.out.println(order1.getStatusMessage());
    order2.setReady(true);
    System.out.println(order2.getStatusMessage());

    order1.getOrderTotal();
    order2.getOrderTotal();

    order1.display();
    order2.display();
    order3.display();
    order4.display();
    order5.display();
    }
}