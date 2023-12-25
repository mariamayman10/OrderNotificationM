package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;

import java.util.List;

public class CompoundOrderC extends OrderCreator{
    @Override
    public Order createOrder(List<Customer> customerList, List<Product> productList) {
        return null;
    }
}
