package OrderNotificationM.example.OrderNotificationM.Services.DBService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Repos.TemplateRepo;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;

import java.util.List;
import java.util.Queue;

public class InMemoryService implements DBService{
    @Override
    public String getProducts() {
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return  UserRepo.getCustomerList();
    }

    @Override
    public List<NotificationTemplate> getTemplates() {
        return TemplateRepo.getTemplateList();
    }
    @Override
    public Queue<Notification> getNotificationQueue() {
        return DBService.notificationQueue;
    }
}
