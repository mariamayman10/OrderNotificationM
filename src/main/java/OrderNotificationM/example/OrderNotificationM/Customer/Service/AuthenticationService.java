package OrderNotificationM.example.OrderNotificationM.Customer.Service;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Database.Service.DBManager;
import lombok.Setter;

@Setter
public abstract class AuthenticationService {
    protected static DBManager DBManager;
    public static void setIdentityManager(DBManager DBManager) {
        AuthenticationService.DBManager = DBManager;
    }

    public abstract Customer logIn(LoginRequest request);
    public abstract boolean signUp(SignUpRequest request);
}
