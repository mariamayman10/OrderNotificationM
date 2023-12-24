package OrderNotificationM.example.OrderNotificationM.Controller;

import OrderNotificationM.example.OrderNotificationM.AuthenticationService.AuthenticationService;
import OrderNotificationM.example.OrderNotificationM.AuthenticationService.LocalAuthenticationService;
import OrderNotificationM.example.OrderNotificationM.Customer.Customer;
import OrderNotificationM.example.OrderNotificationM.Database.Database;
import OrderNotificationM.example.OrderNotificationM.Database.InMemoryDB;
import OrderNotificationM.example.OrderNotificationM.Notification.EmailNotificationService;
import OrderNotificationM.example.OrderNotificationM.Notification.NotificationService;
import OrderNotificationM.example.OrderNotificationM.Notification.SMSNotificationService;
import OrderNotificationM.example.OrderNotificationM.Order.OrderService;
import OrderNotificationM.example.OrderNotificationM.Order.OrderServiceImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Interface {
    private final Customer user = new Customer();
    private final AuthenticationService authenticationService = new LocalAuthenticationService();
    private final Database database = new InMemoryDB();
    private final NotificationService ENotificationService = new EmailNotificationService();
    private final NotificationService SMSNotificationService = new SMSNotificationService();
    private final OrderService orderService = new OrderServiceImp();

}
