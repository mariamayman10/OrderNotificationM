package OrderNotificationM.example.OrderNotificationM.Services.DBService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Repos.ProductRepo;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;

import java.util.List;

public interface DBService {
    UserRepo userRepo = new UserRepo();
    ProductRepo productRepo = new ProductRepo();
    public String getProducts();
    public List<Customer> getCustomers();
}
