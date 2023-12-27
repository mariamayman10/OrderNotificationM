package OrderNotificationM.example.OrderNotificationM.Services.DBService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Repos.ProductRepo;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DBService {
    UserRepo userRepo = new UserRepo();
    ProductRepo productRepo = new ProductRepo();
    public String getProducts();
    public List<Customer> getCustomers();
}
