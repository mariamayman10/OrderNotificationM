package OrderNotificationM.example.OrderNotificationM.Models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Notification {
    private NotificationTemplate template;
    private Map.Entry<String, List<String>> placeholderValues;
    private String finalContent;
    private Time timeStamp = new Time(0);
}
