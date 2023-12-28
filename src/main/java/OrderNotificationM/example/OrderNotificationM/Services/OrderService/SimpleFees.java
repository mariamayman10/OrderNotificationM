package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;

import java.util.List;

public class SimpleFees implements FeesCalculationStrategy{
    @Override
    public void calculateFees(List<Customer> customerList, double fee) {
//        customerList.getFirst().setBalance(customerList.getFirst().getBalance() - fee);
    }
}
