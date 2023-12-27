package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Infrastructure.Database;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBServiceCreator;

import java.util.List;

public class IdentityManager {
    DBService dbService;
    IdentityManager(DBService dbService){
        this.dbService = dbService;
    }
    public Customer doesExist(String email) {

        for (Customer customer : dbService.getCustomers()) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }
    public Customer validate(String email, String password){
        for (Customer customer : dbService.getCustomers()) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }
}
