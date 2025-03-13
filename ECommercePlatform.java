import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order class
class Order {
    private static int orderCount = 0;
    private int orderId;
    private List<Product> products;

    public Order() {
        this.orderId = ++orderCount;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Products in the Order:");
        double total = 0;
        for (Product product : products) {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
            total += product.getPrice();
        }
        System.out.println("Total Order Price: $" + total);
    }
}

// Customer class
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed an order with Order ID: " + orders.size());
    }

    public void viewOrders() {
        System.out.println("\nCustomer: " + name + " has placed the following orders:");
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}

// E-commerce platform simulation
public class ECommercePlatform {
    public static void main(String[] args) {
        // Creating products
        Product laptop = new Product("Laptop", 1200.00);
        Product phone = new Product("Smartphone", 800.00);
        Product tablet = new Product("Tablet", 500.00);

        // Creating a customer
        Customer customer = new Customer("Alice");

        // Creating an order and adding products
        Order order1 = new Order();
        order1.addProduct(laptop);
        order1.addProduct(phone);

        // Customer places the order
        customer.placeOrder(order1);

        // Creating another order with different products
        Order order2 = new Order();
        order2.addProduct(tablet);

        // Customer places the second order
        customer.placeOrder(order2);

        // Viewing all orders of the customer
        customer.viewOrders();
    }
}