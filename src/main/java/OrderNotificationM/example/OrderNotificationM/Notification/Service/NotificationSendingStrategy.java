package OrderNotificationM.example.OrderNotificationM.Notification.Service;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;
import org.springframework.stereotype.Service;

@Service
public interface NotificationSendingStrategy {
    boolean sendNotification(Notification notification);
}
