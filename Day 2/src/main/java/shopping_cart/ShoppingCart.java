package shopping_cart;

import java.util.*;

class ShoppingCart {
    private Map<String, Double> prices = new HashMap<>();
    private Map<String, Double> orderedItems = new LinkedHashMap<>();
    private TreeMap<Double, String> sortedByPrice = new TreeMap<>();

    public void addItem(String product, double price) {
        prices.put(product, price);
        orderedItems.put(product, price);
        sortedByPrice.put(price, product);
    }

    public void displayCart() {
        System.out.println("Items (Unordered): " + prices);
        System.out.println("Items (Ordered): " + orderedItems);
        System.out.println("Items (Sorted by Price): " + sortedByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 1000);
        cart.addItem("Mouse", 25);
        cart.addItem("Keyboard", 50);

        cart.displayCart();
    }
}
