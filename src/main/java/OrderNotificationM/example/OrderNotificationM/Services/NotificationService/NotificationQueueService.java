package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.*;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.InMemoryService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NotificationQueueService {
    DBService DB = new InMemoryService();
    private Queue<Notification> notificationQueue = DB.getNotificationQueue();
    private List<NotificationTemplate> templates = DB.getTemplates();

    public void addToQueue(NotificationType type, Map<Customer, Product>placeholderValues) {
        Notification notification = new Notification();
        notification.setPlaceholderValues(placeholderValues);
        notification.setStatus(NotificationStatus.PENDING);
        for(NotificationTemplate template: templates){
            if(template.getType() == type && placeholderValues.keySet().iterator().next().getLanguage() == template.getLanguage())
                notification.setTemplate(template);
        }
        notificationQueue.add(notification);
    }

    public Notification processFirstNotification() {
        return notificationQueue.poll();
    }

    public List<Notification> getQueueContent() {
        return new ArrayList<>(notificationQueue);
    }
}
