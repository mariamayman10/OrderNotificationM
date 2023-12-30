package OrderNotificationM.example.OrderNotificationM.Repos;

import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Time;
import java.sql.Timestamp;
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
            if(duration.getSeconds() > 3){
                notificationQueue.poll();
            }
        }
    }
}
