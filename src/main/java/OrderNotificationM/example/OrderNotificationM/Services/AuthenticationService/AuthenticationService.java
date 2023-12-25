package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;

import java.util.List;

public abstract class AuthenticationService {
    public IdentityManager identityManager;
    public void setDBIdentityManager(DBService dbService) {
        this.identityManager = new IdentityManager(dbService);
    }

    public abstract Customer logIn(String email, String password);
    public abstract boolean signUp();
}
