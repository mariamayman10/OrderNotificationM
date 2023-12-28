package OrderNotificationM.example.OrderNotificationM.Models;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.Map;

public class Notification {
    private NotificationTemplate template;
    public NotificationStatus status;
    private Map<Customer, Product> placeholderValues;
    private final Time timeStamp = new Time(0);
    public Map<Customer,Product> getPlaceholderValues(){
        return this.placeholderValues;
    }
    public NotificationTemplate getTemplate(){
        return this.template;
    }
    public NotificationStatus getStatus(){return this.status;}
    public void setStatus(NotificationStatus notificationStatus){
        this.status = notificationStatus;
    }
    public void setTemplate(NotificationTemplate template){
        this.template = template;
    }
    public void setPlaceholderValues(Map<Customer, Product> placeholderValues){
        this.placeholderValues = placeholderValues;
    }

}
