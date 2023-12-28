package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class EmailNotification implements NotificationSendingStrategy {

    @Override
    public Notification sendNotification(Notification notification) {
        NotificationTemplate template = notification.getTemplate();
        String content = template.getContent();
        Map<Customer, Product> placeholderValues = notification.getPlaceholderValues();

        for (Map.Entry<Customer, Product> entry : placeholderValues.entrySet()) {
            String finalContent = content;
            Customer customer = entry.getKey();
            Product product = entry.getValue();

            String customerName = customer.getName();
            String productName = product.getName();

            finalContent = content.replace("{x}", customerName);
            finalContent = content.replace("{y}", productName);

            System.out.println(finalContent);
        }



        return notification;
    }
}
