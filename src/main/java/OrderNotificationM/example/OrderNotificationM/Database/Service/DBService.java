package OrderNotificationM.example.OrderNotificationM.Database.Service;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Database.Repo.ProductRepo;
import OrderNotificationM.example.OrderNotificationM.Notification.Repo.TemplateRepo;
import OrderNotificationM.example.OrderNotificationM.Customer.Repo.CustomerRepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;

@Getter
@Setter
@Service
public abstract class DBService {
    protected CustomerRepo userRepo = new CustomerRepo();
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
