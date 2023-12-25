package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.Type;

import java.util.HashMap;
import java.util.Map;

public abstract class NotificationService {
    Map<Type, Notification> templates = new HashMap<>();
    public abstract Notification sendNotification(Customer c);
}
