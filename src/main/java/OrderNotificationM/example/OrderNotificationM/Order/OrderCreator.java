package OrderNotificationM.example.OrderNotificationM.Order;

import OrderNotificationM.example.OrderNotificationM.Customer.Customer;
import OrderNotificationM.example.OrderNotificationM.Product;

import java.util.List;

public abstract class OrderCreator {
    private final OrderServiceImp orderServiceImp = new OrderServiceImp();
    public abstract Order createOrder(List<Customer> customerList, List<Product> productList);
}
