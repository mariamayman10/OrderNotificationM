package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Order;
import org.springframework.stereotype.Service;

@Service
public abstract class OrderService {
    public abstract Order createOrder(String type);
}
