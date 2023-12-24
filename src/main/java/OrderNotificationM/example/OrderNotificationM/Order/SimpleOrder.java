package OrderNotificationM.example.OrderNotificationM.Order;

import OrderNotificationM.example.OrderNotificationM.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder extends Order{
    List<Product> productList = new ArrayList<>();
    @Override
    public String printOrder() {
        return null;
    }
}
