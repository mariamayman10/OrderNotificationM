package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationStatus;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static OrderNotificationM.example.OrderNotificationM.Models.NotificationStatus.SENT;


@Service
public class NotificationService {
    @Autowired
    NotificationQueueService notificationQueueService = new NotificationQueueService();
    @Autowired
    NotificationSendingStrategy notificationSendingStrategy = new EmailNotification();

    public void sendNotification(){
        if (!notificationQueueService.getQueueContent().isEmpty()) {
            Notification notification = notificationQueueService.processFirstNotification();
            notificationSendingStrategy.sendNotification(notification);
            notification.setStatus(NotificationStatus.SENT);
        }
    }
}
