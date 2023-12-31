package OrderNotificationM.example.OrderNotificationM.Notification.Repo;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Notification.Models.NotificationStatus;
import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

@Component
@Repository
public class NotificationsRepo {

    @Getter
    private static Queue<Notification> notificationQueue = new ArrayDeque<>();

    @Scheduled(fixedRate = 1000)
    private void updateNotificationQueue(){
        Iterator<Notification> iterator = notificationQueue.iterator();
        while (iterator.hasNext()) {
            Notification n = iterator.next();
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime creationTime = n.getTimeStamp().toLocalTime().atDate(currentTime.toLocalDate());
            Duration duration = Duration.between(creationTime, currentTime);
            n.setNotificationStatus(NotificationStatus.SENT);
            if (duration.getSeconds() > 30) {
                iterator.remove();
            }
        }
    }

}
