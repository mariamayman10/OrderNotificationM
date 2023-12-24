package OrderNotificationM.example.OrderNotificationM.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Customer.Customer;
import OrderNotificationM.example.OrderNotificationM.Database.Database;
import OrderNotificationM.example.OrderNotificationM.Database.InMemoryDB;

public class IdentityManager {
    Database database = new InMemoryDB();
    public Customer doesExist(String email){
        return null;
    }
    public Customer validate(String email, String password){
        return null;
    }
}
