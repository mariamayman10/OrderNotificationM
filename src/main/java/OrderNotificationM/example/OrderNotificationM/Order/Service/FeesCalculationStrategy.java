package OrderNotificationM.example.OrderNotificationM.Order.Service;

import OrderNotificationM.example.OrderNotificationM.Order.Models.Order;


public interface FeesCalculationStrategy {
    void calculateFees(Order order);
}
