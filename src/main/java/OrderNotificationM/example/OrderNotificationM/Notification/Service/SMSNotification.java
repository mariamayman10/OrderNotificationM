package OrderNotificationM.example.OrderNotificationM.Notification.Service;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;

public class SMSNotification implements NotificationSendingStrategy {

    @Override
    public boolean sendNotification(Notification notification) {
        return true;
    }
}
