package OrderNotificationM.example.OrderNotificationM.Notification;

import OrderNotificationM.example.OrderNotificationM.Customer.Customer;

import java.util.HashMap;
import java.util.Map;

public abstract class NotificationService {
    Map<Type, Notification> templates = new HashMap<>();
    public abstract Notification sendNotification(Customer c);
}
