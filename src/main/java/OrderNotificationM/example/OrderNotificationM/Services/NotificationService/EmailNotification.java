package OrderNotificationM.example.OrderNotificationM.Services.NotificationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Models.Product;

import java.util.Map;

public class EmailNotification implements NotificationSendingStrategy {

    @Override
    public Notification sendNotification(Notification notification) {
        NotificationTemplate template = notification.getTemplate();
        String content = template.getContent();
        Map<Customer, Product> placeholderValues = notification.getPlaceholderValues();

        for (Map.Entry<Customer, Product> entry : placeholderValues.entrySet()) {
            Customer customer = entry.getKey();
            Product product = entry.getValue();

            String customerName = customer.getName();
            String productName = product.getName();

            content = content.replace("{x}", customerName);
            content = content.replace("{y}", productName);
        }

        System.out.println(content);

        return notification;
    }
}
