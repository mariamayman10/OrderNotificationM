package OrderNotificationM.example.OrderNotificationM.Database.Repo;

import OrderNotificationM.example.OrderNotificationM.Database.Models.*;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository

public class ProductRepo{
    @Getter
    private static Map<Category, List<Product>> productList = new HashMap<>();
    public ProductRepo(){
        productList.put(Category.ELECTRONICS, new ArrayList<>(Arrays.asList(
                new Product("1", "Laptop", "Vendor A", 999.99, Category.ELECTRONICS, 20),
                new Product("2", "Smartphone", "Vendor B", 599.99, Category.ELECTRONICS, 4)

        )));
        productList.put(Category.DESERT, new ArrayList<>(Arrays.asList(
                new Product("3", "Chocolates", "Vendor C", 5.99, Category.DESERT, 55),
                new Product("5", "Cookies", "Vendor E", 3.49, Category.DESERT, 67),
                new Product("8","Dar Chocolate","Vendor Z", 10.0, Category.DESERT, 32)
        )));
        productList.put(Category.BOOKS, new ArrayList<>(Arrays.asList(
                new Product("6", "Java Programming", "Vendor F", 49.99, Category.BOOKS, 12),
                new Product("7", "Data Structures", "Vendor G", 39.99, Category.BOOKS, 7)
        )));
    }
}