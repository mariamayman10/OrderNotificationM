package OrderNotificationM.example.OrderNotificationM.Database;

import OrderNotificationM.example.OrderNotificationM.Category;
import OrderNotificationM.example.OrderNotificationM.Customer.Customer;
import OrderNotificationM.example.OrderNotificationM.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Database {
    Map<Category, List<Product>> productList = new HashMap<>();


    List<Customer> customerList = new ArrayList<>();
    public abstract String getProducts();
    public abstract String getNotifications();


}
