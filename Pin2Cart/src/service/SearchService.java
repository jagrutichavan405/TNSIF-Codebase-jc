package service;

import java.util.ArrayList;
import java.util.List;
import model.Product;

public class SearchService {

    public List<Product> searchByKeyword(String keyword) {
        List<Product> results = new ArrayList<>();

        keyword = keyword.toLowerCase().trim();

        // 🔴 Keyword-based matching
        if (keyword.contains("shirt") || keyword.contains("bow")) {
            results.add(new Product(
                1,
                "Red Bow",
                799.0,
                "Amazon",
                0.88,
                "https://www.amazon.in/Tuxedo-Bow-Tie-Bowtie-Necktie/dp/B01F5FY4KQ",
                false
            ));
            results.add(new Product(
                2,
                "Floral Shirt",
                999.0,
                "Flipkart",
                0.82,
                "https://www.flipkart.com/houseofcommon-men-floral-print-casual-white-shirt/p/itm16ec7036e5f3a?pid=SHTH4KHA68N9EQGE&lid=LSTSHTH4KHA68N9EQGEHUFILG&marketplace=FLIPKART&q=floral+shirt+for+men&store=clo%2Fash%2Faxc%2Fmmk%2Fkp7&srno=s_1_36&otracker=AS_QueryStore_OrganicAutoSuggest_1_11_sc_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_11_sc_na_na&fm=search-autosuggest&iid=df9a4665-0955-454e-98d2-01e4c20d09cf.SHTH4KHA68N9EQGE.SEARCH&ppt=sp&ppn=sp&ssid=ljr9zfewfk0000001752484679899&qH=fade658548bbb791",
                false
            ));
        }

        if (keyword.contains("lamp")) {
            results.add(new Product(
                3,
                "Vintage Lamp",
                1299.0,
                "Amazon",
                0.92,
                "https://www.amazon.in/PRIMESKY%C2%AE-Changing-Night-Beautiful-Decoration-15CM/dp/B091N6919B",
                false
            ));
        }

        // ✅ Pinterest Image Matching - Red Bow Shirt
        if (keyword.contains("137ad6168313072c64879b4eb31849c7")) {
            results.add(new Product(
                4,
                "Red Bow (from Pinterest Image)",
                799.0,
                "Amazon",
                0.95,
                "https://www.amazon.in/Tuxedo-Bow-Tie-Bowtie-Necktie/dp/B01F5FY4KQ",
                false
            ));
        }

        // ✅ Pinterest Image Matching - Moon Lamp
        if (keyword.contains("f7d5433be6aac42c66f3e2b9352f128f")) {
            results.add(new Product(
                5,
                "Moon Lamp - LED Night Light (from Pinterest Image)",
                1299.0,
                "Amazon",
                0.96,
                "https://www.amazon.in/PRIMESKY%C2%AE-Changing-Night-Beautiful-Decoration-15CM/dp/B091N6919B",
                false
            ));
        }

        if (results.isEmpty()) {
            System.out.println("❌ No matching products found for: " + keyword);
        }

        return results;
    }
}
