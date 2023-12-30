package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class EmailNotification implements NotificationSendingStrategy {
    @Override
    public boolean sendNotification(Notification notification) {
        return true;
    }
}
