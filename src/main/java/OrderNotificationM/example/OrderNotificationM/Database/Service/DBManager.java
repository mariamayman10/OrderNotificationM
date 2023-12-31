package OrderNotificationM.example.OrderNotificationM.Database.Service;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Customer.Repo.CustomerRepo;
import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Notification.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Notification.Repo.NotificationsRepo;
import OrderNotificationM.example.OrderNotificationM.Notification.Repo.TemplateRepo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@Getter
@Setter
public class DBManager {
    private DBService dbService;
    public int getAvailableQuantity(Product product){
        return dbService.getAvailableQuantity(product);
    }
    public Product getProduct(String serialN){
        return dbService.getProduct(serialN);
    }
    public void updateProducts(Map<Product, Integer> products){
        dbService.updateProducts(products);
    }
    public Customer getCustomer(String email){
        return dbService.getCustomer(email);
    }
    public Customer validate(String email, String password){
        return dbService.validate(email, password);
    }
    public List<Customer> getCustomers(){
        return CustomerRepo.getCustomerList();
    }
    public List<NotificationTemplate> getTemplates(){
        return TemplateRepo.getTemplateList();
    }
    public Map<NotificationTemplate, Integer> getTemplatesCount(){
        return TemplateRepo.getTemplateCount();
    }
    public Queue<Notification> getNotifications(){
        return NotificationsRepo.getNotificationQueue();
    }
}
