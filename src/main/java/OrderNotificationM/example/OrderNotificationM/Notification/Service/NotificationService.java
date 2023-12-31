package OrderNotificationM.example.OrderNotificationM.Notification.Service;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.*;
import OrderNotificationM.example.OrderNotificationM.Database.Service.DBManager;
import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import lombok.Setter;
import org.springframework.stereotype.Service;


import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

// templates are initialized twice

@Service
@Setter
public class NotificationService {
    private static DBManager DBManager;
    NotificationSendingStrategy notificationSendingStrategy = new EmailNotification();

    public static void setDBManager(DBManager DBManager) {
        NotificationService.DBManager = DBManager;
    }

    public String createNotification(NotificationType type, Map<Product, Integer> productList, String email){
        Customer customer = DBManager.getCustomer(email);
        Notification notification = new Notification();
        // get product names
        List<String> productNames = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry: productList.entrySet()){
            productNames.add(entry.getKey().getName());
        }
        // set placeholders
        Map.Entry<String, List<String>> placeholderValues =
                new AbstractMap.SimpleEntry<>(customer.getName(), productNames);
        notification.setPlaceholderValues(placeholderValues);
        // set template
        for(NotificationTemplate template: DBManager.getTemplates()){
            if(template.getType() == type && customer.getLanguage() == template.getLanguage())
                notification.setTemplate(template);
        }
        notification = setNotificationContent(notification);

        LocalDateTime currentDateTime = LocalDateTime.now();
        notification.setTimeStamp(Time.valueOf(currentDateTime.toLocalTime()));
        notification.setNotificationStatus(NotificationStatus.PENDING);

        DBManager.getNotifications().add(notification);
        DBManager.getTemplatesCount().merge(notification.getTemplate(), 1, Integer::sum);
        customer.getNotificationList().add(notification);
        return notification.getFinalContent();
    }
    public Notification setNotificationContent(Notification notification){
        // create content
        String content = notification.getTemplate().getContent();
        Map.Entry<String, List<String>> placeholders = notification.getPlaceholderValues();
        String finalContent = getString(placeholders, content);
        notification.setFinalContent(finalContent);
        // send notification
        notificationSendingStrategy.sendNotification(notification);
        return notification;
    }
    private static String getString(Map.Entry<String, List<String>> placeholders, String content) {
        String customerName = placeholders.getKey();
        String productNames = "";
        List<String> products = placeholders.getValue();
        for(String s: products){
            productNames += s;
            productNames += ", ";
        }
        productNames = productNames.substring(0, productNames.length() - 2);
        String finalContent = content;
        finalContent = finalContent.replace("{x}", customerName);
        finalContent = finalContent.replace("{y}", productNames);
        return finalContent;
    }
}
