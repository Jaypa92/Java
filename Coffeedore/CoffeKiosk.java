import java.util.ArrayList;

public class CoffeKiosk {
    private ArrayList<Item>menu;
    private ArrayList<Order>orders;

    public CoffeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
        Item item = new Item(name,price);
        menu.add(item);
        item.setIndex(menu.indexOf(item));
    }

    public void displayMenu(){
        for(Item item: menu){
            System.out.println(item.getIndex() + " " + item.getName() + "  $" + item.getPrice() );
        }
    }

    public void newOrder(){
        System.out.println("Please enter name for a new order");
        String name = System.console().readLine();

        Order order6 = new Order(name);

        displayMenu();

        System.out.println("Please eneter a menu item index or q to quit");
        String itemNumber = System.console().readLine();

        while(!itemNumber.equals("q")){
            try{
                order6.addItem(menu.get(Integer.parseInt(itemNumber)));
            }catch(IndexOutOfBoundsException i){
                System.out.println("Invalid Selection!");
            }catch(NumberFormatException n){
                System.out.println("Invalid Selection!");
            }
            System.out.println("Please enetr a menu item index or q to quit");
            itemNumber = System.console().readLine();
        }

        order6.display();
    }
}