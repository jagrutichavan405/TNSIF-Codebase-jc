package model;
import java.util.List;
import model.Product;

//main admin class
public class admin extends User {// used inheritence from user
    private int adminId;

    
    public void login() {
        System.out.println("Admin " + username + " logged in.");
    }

    
    public void logout() {
        System.out.println("Admin " + username + " logged out.");
    }

    public void viewFlaggedProducts(List<Product> products) {
        for (Product p : products) {
            if (p.isFlagged()) System.out.println(p);
        }
    }
}
