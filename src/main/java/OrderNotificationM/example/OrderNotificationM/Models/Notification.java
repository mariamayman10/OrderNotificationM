package OrderNotificationM.example.OrderNotificationM.Models;

import java.sql.Time;

public class Notification {
    private final Template template = new Template();
    private NotificationStatus notificationStatus;
    private final Time timeStamp = new Time(0);
}
