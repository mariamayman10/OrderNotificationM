package OrderNotificationM.example.OrderNotificationM.Notification.Controller;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.NotificationType;
import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Notification.Service.NotificationService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@RestController
public class NotificationController {
    NotificationService notificationService;
    public NotificationController(){
        this.notificationService = new NotificationService();
    }
    public String createNotification(NotificationType type, Map<Product, Integer> productList, String email){
        return notificationService.createNotification(type, productList, email);
    }
}
