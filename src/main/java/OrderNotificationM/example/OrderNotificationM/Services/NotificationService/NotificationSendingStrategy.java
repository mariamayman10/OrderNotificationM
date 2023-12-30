package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import org.springframework.stereotype.Service;

@Service
public interface NotificationSendingStrategy {
    boolean sendNotification(Notification notification);
}
