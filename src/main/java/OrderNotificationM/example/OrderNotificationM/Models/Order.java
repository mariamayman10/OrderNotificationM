package OrderNotificationM.example.OrderNotificationM.Models;

import OrderNotificationM.example.OrderNotificationM.Services.OrderService.FeesCalculationStrategy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.Time;
@Getter
@Setter
public abstract class Order {
    private String id;
    private OrderStatus status;
    private double totalPrice;
    FeesCalculationStrategy feesCalculationStrategy;
    private final Time timeStamp = new Time(0);
    public abstract String printOrder();
}
