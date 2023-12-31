package OrderNotificationM.example.OrderNotificationM.Notification.Models;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Language;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationTemplate {
    private String content;
    private NotificationType type;
    private Language language;
}
