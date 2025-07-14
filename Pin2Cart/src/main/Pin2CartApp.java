package main;

import java.util.*;
import model.*;
import service.*;

public class Pin2CartApp {

    static Scanner sc = new Scanner(System.in);
    static SearchService searchService = new SearchService();
    static CustomerService customerService = new CustomerService();
    static AdminService adminService = new AdminService();
    static List<ClickLog> clickLogs = new ArrayList<>();
    static List<Product> allProducts = new ArrayList<>();

    public static void main(String[] args) {

        // 🟨 Welcome Banner
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║           Welcome to 🛒 Pin2Cart           ║");
        System.out.println("║  Find What You Love, Buy What You See 💖   ║");
        System.out.println("╚════════════════════════════════════════════╝");

        while (true) {
            System.out.println("\nChoose Role:");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> customerMenu();
                case 2 -> adminMenu();
                case 3 -> {
                    System.out.println("Thank you for using Pin2Cart!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static void customerMenu() {
        Customer currentCustomer = new Customer();
        Cart cart = new Cart();

        System.out.println("Enter your User ID:");
        currentCustomer.setUserId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter your name:");
        currentCustomer.setUsername(sc.nextLine());
        System.out.println("Enter your email:");
        currentCustomer.setEmail(sc.nextLine());

        customerService.createCustomer(currentCustomer);
        System.out.println("🎉 Welcome, " + currentCustomer.getUsername() + "!");

        boolean running = true;
        while (running) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Search by Keyword");
            System.out.println("2. View Matched Products");
            System.out.println("3. Add Product to Wishlist");
            System.out.println("4. View Wishlist");
            System.out.println("5. Add Product to Cart");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout");
            System.out.println("8. Redirect to Buy");
            System.out.println("9. Search by Link (Paste Pinterest URL)");
            System.out.println("10. Exit");

            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid menu choice. Enter a number between 1–10.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter keyword to search:");
                    String keyword = sc.nextLine();
                    List<Product> matched = searchService.searchByKeyword(keyword);
                    currentCustomer.setSearchResults(matched);
                    allProducts.addAll(matched);
                    System.out.println("Search complete! Here are your matched products:");
                    for (Product p : matched) {
                        System.out.println(p);
                    }
                }
                case 2 -> {
                    System.out.println("Matched Products:");
                    for (Product p : currentCustomer.getSearchResults()) {
                        System.out.println(p);
                    }
                }
                case 3 -> {
                    System.out.println("Enter Product ID to add to wishlist:");
                    if (sc.hasNextInt()) {
                        int pid = sc.nextInt();
                        for (Product p : currentCustomer.getSearchResults()) {
                            if (p.getProductId() == pid) {
                                customerService.addToWishlist(currentCustomer, p);
                            }
                        }
                    } else {
                        System.out.println("❌ Invalid input! Enter a numeric Product ID.");
                        sc.nextLine();
                    }
                }
                case 4 -> customerService.showWishlist(currentCustomer);

                case 5 -> {
                    System.out.println("Enter Product ID to add to cart:");
                    if (sc.hasNextInt()) {
                        int pid = sc.nextInt();
                        for (Product p : currentCustomer.getSearchResults()) {
                            if (p.getProductId() == pid) {
                                cart.add(p);
                                System.out.println("🛒 Added to cart: " + p.getName());
                            }
                        }
                    } else {
                        System.out.println("❌ Invalid input! Enter a numeric Product ID.");
                        sc.nextLine();
                    }
                }

                case 6 -> cart.view();

                case 7 -> {
                    if (cart.getItems().isEmpty()) {
                        System.out.println("🛒 Your cart is empty! Add items before checkout.");
                        break;
                    }

                    System.out.println("Enter Full Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Delivery Address:");
                    String address = sc.nextLine();

                    System.out.println("Enter Phone Number:");
                    String phone = sc.nextLine();

                    Order order = new Order(cart.getItems(), cart.total(), name, address, phone);
                    order.printReceipt();
                    cart.clear();
                    System.out.println("✅ Order placed successfully!");
                }

                case 8 -> {
                    System.out.println("Enter Product ID to buy (redirect):");
                    if (sc.hasNextInt()) {
                        int bid = sc.nextInt();
                        for (Product p : currentCustomer.getSearchResults()) {
                            if (p.getProductId() == bid) {
                                currentCustomer.redirectToPurchase(p);
                                clickLogs.add(new ClickLog(
                                        currentCustomer.getUserId(),
                                        p.getProductId(),
                                        new Date(),
                                        p.getRedirectLink()));
                            }
                        }
                    } else {
                        System.out.println("❌ Invalid input! Enter a numeric Product ID.");
                        sc.nextLine();
                    }
                }

                case 9 -> {
                    System.out.println("📎 Paste your Pinterest image link:");
                    String link = sc.nextLine();
                    String extracted = extractPinterestHash(link);
                    List<Product> matched = searchService.searchByKeyword(extracted);
                    currentCustomer.setSearchResults(matched);
                    allProducts.addAll(matched);
                    System.out.println("🔍 Image Search complete! Matched products:");
                    for (Product p : matched) {
                        System.out.println(p);
                    }
                }

                case 10 -> running = false;

                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ✅ Extract Pinterest image hash or pin ID
    public static String extractPinterestHash(String url) {
        if (url.contains("pinimg.com/")) {
            return url.substring(url.lastIndexOf("/") + 1).replace(".jpg", "");
        } else if (url.contains("pinterest.com/pin/")) {
            return url.substring(url.lastIndexOf("/") + 1).replace("/", "");
        } else {
            return url;
        }
    }

    public static void adminMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View Flagged Products");
            System.out.println("2. View Click Logs");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> adminService.viewFlaggedProducts(allProducts);
                case 2 -> adminService.viewClickLogs(clickLogs);
                case 3 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
