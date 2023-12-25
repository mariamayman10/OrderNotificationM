package OrderNotificationM.example.OrderNotificationM.Services.DBService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;

import java.util.List;

public class InMemoryService implements DBService{
    @Override
    public String getProducts() {
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return  UserRepo.getCustomerList();
    }
}
