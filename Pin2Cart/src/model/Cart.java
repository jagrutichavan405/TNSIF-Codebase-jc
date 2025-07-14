package model;

import java.util.List;
import java.util.ArrayList;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void add(Product p) {
        items.add(p);
    }

    public void remove(Product p) {
        items.remove(p);
    }

    public void view() {
        if (items.isEmpty()) {
            System.out.println("🛒 Your cart is empty.");
        } else {
            System.out.println("🛍️ Your Cart:");
            items.forEach(System.out::println);
        }
    }

    public double total() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
