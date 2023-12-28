package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationType;
import org.springframework.stereotype.Service;

@Service
public interface NotificationSendingStrategy {
    public Notification sendNotification(Notification notification);
}
