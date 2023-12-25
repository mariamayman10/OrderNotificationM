package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;

import java.util.List;

public abstract class OrderCreator {
    private final OrderServiceImp orderServiceImp = new OrderServiceImp();
    public abstract Order createOrder(List<Customer> customerList, List<Product> productList);
}
