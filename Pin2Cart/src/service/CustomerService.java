
package service;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Product;
import model.SearchQuery;

public class CustomerService {
    public static List<Customer> customers = new ArrayList<>();

    public void createCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer created: " + customer.getUsername());
    }

    public void addToWishlist(Customer customer, Product product) {
        customer.getWishlist().add(product);
        System.out.println("Added to wishlist: " + product.getName());
    }

    public void showWishlist(Customer customer) {
        System.out.println("Your Wishlist:");
        for (Product p : customer.getWishlist()) {
            System.out.println(p);
        }
    }
}
