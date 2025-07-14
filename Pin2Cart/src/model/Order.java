package model;

import java.util.Date;
import java.util.List;

public class Order {
    private List<Product> products;
    private double total;
    private Date timestamp;
    private String customerName;
    private String deliveryAddress;
    private String phoneNumber;

    public Order(List<Product> products, double total, String customerName, String deliveryAddress, String phoneNumber) {
        this.products = products;
        this.total = total;
        this.timestamp = new Date();
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
    }

    public void printReceipt() {
        System.out.println("🧾 Order Receipt");
        System.out.println("------------------------------");
        for (Product p : products) {
            System.out.println(p);
        }
        System.out.println("📦 Name       : " + customerName);
        System.out.println("📍 Address    : " + deliveryAddress);
        System.out.println("📞 Phone      : " + phoneNumber);
        System.out.println("💰 Total      : ₹" + total);
        System.out.println("🕒 Ordered at : " + timestamp);
    }
}
