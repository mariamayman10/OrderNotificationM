package OrderNotificationM.example.OrderNotificationM.Order.Models;

import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Order.Service.FeesCalculationStrategy;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class Order {
    private Map<Product, Integer> productList = new HashMap<>();
    private OrderStatus status;
    private double totalPrice;
    private FeesCalculationStrategy feesCalculationStrategy;
    private int orderID;
    private final Time timeStamp = new Time(0);
    public abstract String printOrder();
}
