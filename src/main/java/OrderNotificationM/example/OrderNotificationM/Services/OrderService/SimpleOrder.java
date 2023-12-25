package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder extends Order {
    List<Product> productList = new ArrayList<>();
    @Override
    public String printOrder() {
        return null;
    }
}
