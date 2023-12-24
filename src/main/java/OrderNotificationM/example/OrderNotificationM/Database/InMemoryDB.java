package OrderNotificationM.example.OrderNotificationM.Database;

import OrderNotificationM.example.OrderNotificationM.Category;
import OrderNotificationM.example.OrderNotificationM.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/products")
public class InMemoryDB extends Database{
    public InMemoryDB() {
        productList.put(Category.ELECTRONICS, new ArrayList<>(Arrays.asList(
                new Product("1", "Laptop", "Vendor A", 999.99, Category.ELECTRONICS),
                new Product("2", "Smartphone", "Vendor B", 599.99, Category.ELECTRONICS)

        )));
        productList.put(Category.DESERT, new ArrayList<>(Arrays.asList(
                new Product("3", "Chocolates", "Vendor C", 5.99, Category.DESERT),
                new Product("5", "Cookies", "Vendor E", 3.49, Category.DESERT),
                new Product("8","Dar Chocolate","Vendor Z", 10.0, Category.DESERT)
        )));
        productList.put(Category.BOOKS, new ArrayList<>(Arrays.asList(
                new Product("6", "Java Programming", "Vendor F", 49.99, Category.BOOKS),
                new Product("7", "Data Structures", "Vendor G", 39.99, Category.BOOKS)
        )));
    }

    @Override
    @GetMapping
    public String getProducts() {
        StringBuilder productsInfo = new StringBuilder();

        for (Map.Entry<Category, List<Product>> entry : productList.entrySet()) {
            Category category = entry.getKey();
            List<Product> products = entry.getValue();

            productsInfo.append("Category: ").append(category).append("\n");

            for (Product product : products) {
                productsInfo.append("Serial Number: ").append(product.getSerialNumber())
                        .append(", Name: ").append(product.getName())
                        .append(", Vendor: ").append(product.getVendor())
                        .append(", Price: ").append(product.getPrice())
                        .append("\n");
            }
            productsInfo.append("\n");
        }

        return productsInfo.toString();
    }

    @Override
    public String getNotifications() {
        return null;
    }
}
