package OrderNotificationM.example.OrderNotificationM.Controllers;

import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Services.NotificationService.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    NotificationService notificationService;
    public NotificationController() {
        notificationService = new NotificationService();
    }
    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(){
        notificationService.sendNotification();
        return ResponseEntity.ok("Notification sent successfully!");
    }

}
