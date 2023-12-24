package OrderNotificationM.example.OrderNotificationM.Order;

import OrderNotificationM.example.OrderNotificationM.Customer.Customer;
import OrderNotificationM.example.OrderNotificationM.Product;

import java.util.List;

public class CompoundOrderC extends OrderCreator{
    @Override
    public Order createOrder(List<Customer> customerList, List<Product> productList) {
        return null;
    }
}
