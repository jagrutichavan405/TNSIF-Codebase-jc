package model;

import java.util.*;
import java.awt.Desktop;
import java.net.URI;

public class Customer extends User {

    private List<Product> wishlist = new ArrayList<>();
    private List<Product> searchResults = new ArrayList<>();
    private List<SearchQuery> searches = new ArrayList<>();

    @Override
    public void login() {
        System.out.println(username + " logged in.");
    }

    @Override
    public void logout() {
        System.out.println(username + " logged out.");
    }

    public void addToWishlist(Product product) {
        wishlist.add(product);
    }

    public void redirectToPurchase(Product product) {
        System.out.println("Redirecting to: " + product.getRedirectLink());

        try {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(new URI(product.getRedirectLink()));
            } else {
                System.out.println("Opening browser not supported on this system.");
            }
        } catch (Exception e) {
            System.out.println("Failed to open link: " + e.getMessage());
        }
    }

    public List<Product> getWishlist() {
        return wishlist;
    }

    public List<Product> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Product> searchResults) {
        this.searchResults = searchResults;
    }
}
