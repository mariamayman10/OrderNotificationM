package OrderNotificationM.example.OrderNotificationM.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class NotificationTemplate {

    private String content;
    private NotificationType type;
    private Language language;

    public NotificationType getType(){
        return this.type;
    }
    public String getContent(){return this.content;}
    public Language getLanguage(){return this.language;}
    public void setType(NotificationType type){this.type = type;}
    public void setContent(String content){this.content = content;}
    public void setLanguage(Language language){this.language = language;}
}
