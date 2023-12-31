package OrderNotificationM.example.OrderNotificationM.Notification.Repo;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Notification.Models.NotificationStatus;
import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;
public class NotificationsRepo {
    @Getter
    static Queue<Notification> notificationQueue = new ArrayDeque<>();
    @Scheduled(fixedRate = 5000)
    private void updateNotificationQueue(){
        for(Notification n: notificationQueue){
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime creationTime = n.getTimeStamp().toLocalTime().atDate(currentTime.toLocalDate());
            Duration duration = Duration.between(creationTime, currentTime);
            n.setNotificationStatus(NotificationStatus.SENT);
            if(duration.getSeconds() > 3){
                notificationQueue.poll();
            }
        }
    }
}
