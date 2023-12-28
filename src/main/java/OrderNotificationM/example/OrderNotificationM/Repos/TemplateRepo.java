package OrderNotificationM.example.OrderNotificationM.Repos;

import OrderNotificationM.example.OrderNotificationM.Models.Language;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationType;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TemplateRepo {
    @Getter
    static List<NotificationTemplate> templateList = new ArrayList<>();
    public TemplateRepo(){
        NotificationTemplate placementTemplateEN = new NotificationTemplate();
        placementTemplateEN.setContent("Dear {x}, your order for {y} has been placed. Thank you for choosing our store!");
        placementTemplateEN.setType(NotificationType.ORDER_PLACED);
        placementTemplateEN.setLanguage(Language.ENGLISH);
        templateList.add(placementTemplateEN);

        NotificationTemplate shipmentTemplateEN = new NotificationTemplate();
        shipmentTemplateEN.setContent("Hello {x}, your order for {y} has been shipped. It will arrive soon. Thank you for shopping with us!");
        shipmentTemplateEN.setType(NotificationType.ORDER_SHIPPED);
        shipmentTemplateEN.setLanguage(Language.ENGLISH);
        templateList.add(shipmentTemplateEN);

        NotificationTemplate placementTemplateDE = new NotificationTemplate();
        placementTemplateDE.setContent("Liebe {x}, Ihre Bestellung für {y} wurde aufgegeben. Vielen Dank, dass Sie unseren Laden gewählt haben!");
        placementTemplateDE.setType(NotificationType.ORDER_PLACED);
        placementTemplateDE.setLanguage(Language.GERMAN);
        templateList.add(placementTemplateDE);

        NotificationTemplate shipmentTemplateDE = new NotificationTemplate();
        shipmentTemplateDE.setContent("Hallo {x}, Ihre Bestellung für {y} wurde versandt. Es wird bald eintreffen. Vielen Dank für Ihren Einkauf bei uns!");
        shipmentTemplateDE.setType(NotificationType.ORDER_SHIPPED);
        shipmentTemplateDE.setLanguage(Language.GERMAN);
        templateList.add(shipmentTemplateDE);
    }
}