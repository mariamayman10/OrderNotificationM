package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationType;

public class SMSNotification implements NotificationSendingStrategy {

    @Override
    public Notification sendNotification(Notification notification) {
        return null;
    }
}
