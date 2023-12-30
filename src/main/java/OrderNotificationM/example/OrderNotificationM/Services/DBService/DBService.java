package OrderNotificationM.example.OrderNotificationM.Services.DBService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Repos.ProductRepo;
import OrderNotificationM.example.OrderNotificationM.Repos.TemplateRepo;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;

@Getter
@Setter
@Service
public abstract class DBService {
    protected UserRepo userRepo = new UserRepo();
    protected ProductRepo productRepo = new ProductRepo();
    protected TemplateRepo templateRepo = new TemplateRepo();
    protected Queue<Notification> notificationQueue = new LinkedList<>();
    public abstract String getStringProducts();
    public abstract String mostNotifiedCustomer();
    public abstract String mostUsedTemplate();
    public abstract int getAvailableQuantity(Product product);
    public abstract Product getProduct(String serialN);
    public abstract void updateProducts(Map<Product, Integer> products);
    public abstract Customer getCustomer(String email);
    public abstract Customer validate(String email, String password);
    public abstract String getStringNotificationQueue();
}
