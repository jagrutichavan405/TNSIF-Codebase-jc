package model;


import java.util.*;

public class SearchQuery {
    private int queryId;
    private int userId;
    private boolean imageUploaded;
    private String keyword;
    private Date timestamp;
    private List<Product> matchedProducts;

    public void processKeyword(String keyword) {
        // Simulate API call
        System.out.println("Fetching products for: " + keyword);
    }
}
