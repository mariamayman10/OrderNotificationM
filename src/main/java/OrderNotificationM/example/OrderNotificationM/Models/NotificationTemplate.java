package OrderNotificationM.example.OrderNotificationM.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationTemplate {
    private String content;
    private NotificationType type;
    private Language language;
}
