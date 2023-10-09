public class TestOrder {
    public static void main(String[] args) {
        // Creating Item objects
        Item item1 = new Item("Drip Coffee", 1.50);
        Item item2 = new Item("Cappuccino", 3.50);

        // Creating orders
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("John Doe");
        Order order4 = new Order("Jane Smith");
        Order order5 = new Order("Alice Johnson");

        // Adding items to orders
        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item1);
        order2.addItem(item2);

        order3.addItem(item1);
        order3.addItem(item2);

        order4.addItem(item2);

        order5.addItem(item1);

        // Setting orders to ready status
        order2.setReady(true);
        order4.setReady(true);

        // Printing status messages and order totals
        System.out.println(order1.getStatusMessage());
        System.out.println("Order 1 Total: $" + order1.getOrderTotal());

        System.out.println(order2.getStatusMessage());
        System.out.println("Order 2 Total: $" + order2.getOrderTotal());

        System.out.println(order3.getStatusMessage());
        System.out.println("Order 3 Total: $" + order3.getOrderTotal());

        System.out.println(order4.getStatusMessage());
        System.out.println("Order 4 Total: $" + order4.getOrderTotal());

        System.out.println(order5.getStatusMessage());
        System.out.println("Order 5 Total: $" + order5.getOrderTotal());

        // Displaying order information
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}
