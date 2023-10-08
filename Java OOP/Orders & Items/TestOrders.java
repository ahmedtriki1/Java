import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item("mocha", 3.99);
        Item item2 = new Item("latte", 2.99);
        Item item3 = new Item("drip coffee", 1.99);
        Item item4 = new Item("cappuccino", 4.49);
    
        // Order variables
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");
        

        // Adding items to orders
        order1.items.add(item1);
        order1.total += item1.price;
        
        order2.items.add(item3);
        order2.total += item3.price;
        
        order3.items.add(item4);
        order3.total += item4.price;
        
        order4.items.add(item2);
        order4.total += item2.price;

        // Print order1
        System.out.println("Order 1 Details:");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %.2f\n", order1.total);
        System.out.printf("Ready: %b\n", order1.ready);
        
        // Predicted output for order1.total is 0.0 since no items are added yet.
        
        // Add item1 to order2's item list and update order's total
        order2.items.add(item1);
        order2.total += item1.price;
    
        // order3 ordered a cappuccino
        order3.items.add(item4);
        order3.total += item4.price;
    
        // order4 added a latte
        order4.items.add(item2);
        order4.total += item2.price;
    
        // Cindhuri’s order is now ready
        order1.ready = true;
    
        // Sam ordered 2 lattes
        order4.items.add(item2);
        order4.total += item2.price * 2;
    
        // Jimmy’s order is now ready
        order2.ready = true;
    
        // Print updated order1 details
        System.out.println("\nUpdated Order 1 Details:");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %.2f\n", order1.total);
        System.out.printf("Ready: %b\n", order1.ready);
    }
}
