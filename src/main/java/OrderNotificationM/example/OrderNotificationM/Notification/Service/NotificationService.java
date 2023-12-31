package OrderNotificationM.example.OrderNotificationM.Notification.Service;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.*;
import OrderNotificationM.example.OrderNotificationM.Notification.Repo.*;
import OrderNotificationM.example.OrderNotificationM.Database.Service.IdentityManager;
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
    private static IdentityManager identityManager;
    NotificationSendingStrategy notificationSendingStrategy = new EmailNotification();

    public static void setIdentityManager(IdentityManager identityManager) {
        NotificationService.identityManager = identityManager;
    }

    public String createNotification(NotificationType type, Map<Product, Integer> productList, String email){
        Customer customer = identityManager.getCustomer(email);
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
        for(NotificationTemplate template: TemplateRepo.getTemplateList()){
            if(template.getType() == type && customer.getLanguage() == template.getLanguage())
                notification.setTemplate(template);
        }
        NotificationsRepo.getNotificationQueue().add(notification);
        TemplateRepo.getTemplateCount().merge(notification.getTemplate(), 1, Integer::sum);
        customer.getNotificationList().add(notification);
        LocalDateTime currentDateTime = LocalDateTime.now();
        notification.setTimeStamp(Time.valueOf(currentDateTime.toLocalTime()));
        notification.setNotificationStatus(NotificationStatus.PENDING);
        return setNotificationContent(notification);
    }
    public String setNotificationContent(Notification notification){
        // create content
        String content = notification.getTemplate().getContent();
        Map.Entry<String, List<String>> placeholders = notification.getPlaceholderValues();
        String finalContent = getString(placeholders, content);
        notification.setFinalContent(finalContent);
        // send notification
        notificationSendingStrategy.sendNotification(notification);
        return finalContent;
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
