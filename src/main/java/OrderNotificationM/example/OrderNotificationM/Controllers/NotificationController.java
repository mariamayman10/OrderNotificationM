package OrderNotificationM.example.OrderNotificationM.Controllers;

import OrderNotificationM.example.OrderNotificationM.Models.NotificationType;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Services.NotificationService.NotificationService;
import jakarta.annotation.PostConstruct;
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
