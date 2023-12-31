package OrderNotificationM.example.OrderNotificationM.Notification.Service;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;
import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements NotificationSendingStrategy {
    @Override
    public boolean sendNotification(Notification notification) {
        return true;
    }
}
