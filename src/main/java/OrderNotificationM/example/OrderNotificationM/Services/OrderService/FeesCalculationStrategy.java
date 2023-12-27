package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;

import java.util.List;

public interface FeesCalculationStrategy {
    public void calculateFees(List<Customer> customerList, double fee);
}
