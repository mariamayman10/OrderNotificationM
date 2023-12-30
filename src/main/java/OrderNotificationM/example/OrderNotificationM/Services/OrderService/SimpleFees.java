package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
public class SimpleFees implements FeesCalculationStrategy{
    Customer customer;
    @Override
    public void calculateFees(Order order) {
        double totalPrice = 0;
        Map<Product, Integer> productList = order.getProductList();
        for(Map.Entry<Product, Integer> e: productList.entrySet()){
            totalPrice += e.getKey().getPrice() * e.getValue();
        }
        customer.setBalance(customer.getBalance()-totalPrice);
        System.out.println(customer.getBalance());
    }
}
