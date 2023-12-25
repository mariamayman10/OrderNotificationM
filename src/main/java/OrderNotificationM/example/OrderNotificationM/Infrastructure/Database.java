package OrderNotificationM.example.OrderNotificationM.Infrastructure;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Database {
    public abstract String getProducts();
    public abstract List<Customer> getCustomers();
}
