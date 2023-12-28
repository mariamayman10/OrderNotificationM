package OrderNotificationM.example.OrderNotificationM.Services.DBService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Repos.ProductRepo;
import OrderNotificationM.example.OrderNotificationM.Repos.TemplateRepo;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public interface DBService {
    UserRepo userRepo = new UserRepo();
    ProductRepo productRepo = new ProductRepo();
    TemplateRepo templateRepo = new TemplateRepo();
    @Getter
    Queue<Notification> notificationQueue= new LinkedList<>();
    public String getProducts();
    public List<Customer> getCustomers();
    public List<NotificationTemplate> getTemplates();
    public Queue<Notification> getNotificationQueue();
}
