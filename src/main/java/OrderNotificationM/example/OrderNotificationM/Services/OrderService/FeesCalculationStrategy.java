package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Order;


public interface FeesCalculationStrategy {
    void calculateFees(Order order);
}
