package OrderNotificationM.example.OrderNotificationM.Models;

import OrderNotificationM.example.OrderNotificationM.Services.OrderService.FeesCalculationStrategy;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
public abstract class Order {
    private OrderStatus status;
    private double totalPrice;
    FeesCalculationStrategy feesCalculationStrategy;
    private final Time timeStamp = new Time(0);
    public abstract String printOrder();
}
