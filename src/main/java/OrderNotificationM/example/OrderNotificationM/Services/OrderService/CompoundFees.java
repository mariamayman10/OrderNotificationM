package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;

import java.util.List;

public class CompoundFees implements FeesCalculationStrategy{
    @Override
    public void calculateFees(List<Customer> customerList, double fee) {
        for(Customer c: customerList){
            c.setBalance(c.getBalance() - fee);
        }
    }
}
