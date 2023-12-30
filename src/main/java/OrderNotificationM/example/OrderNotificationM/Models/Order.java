package OrderNotificationM.example.OrderNotificationM.Models;

import OrderNotificationM.example.OrderNotificationM.Services.OrderService.FeesCalculationStrategy;
import lombok.Generated;
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
