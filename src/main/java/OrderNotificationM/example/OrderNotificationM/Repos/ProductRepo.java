package OrderNotificationM.example.OrderNotificationM.Repos;

import OrderNotificationM.example.OrderNotificationM.Models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepo{
    static List<Product> productList = new ArrayList<>();
}