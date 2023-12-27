package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleOrder extends Order {
    Map<Product, Integer> productList = new HashMap<>();
    @Override
    public String printOrder() {
        StringBuilder response = new StringBuilder();
        response.append("Order ID: ").append(this.getId()).append('\n');
        for (Map.Entry<Product,Integer> entry : productList.entrySet()){
            response.append("Product Name: ").append(entry.getKey().getName()).append(" ")
                    .append("Quantity: ").append(entry.getValue())
                    .append("TotalPrice: ").append(entry.getKey().getPrice() * entry.getValue());
        }
        return String.valueOf(response);
    }
}
