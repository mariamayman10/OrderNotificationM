package OrderNotificationM.example.OrderNotificationM.Customer.Service;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Database.Service.IdentityManager;
import lombok.Setter;

@Setter
public abstract class AuthenticationService {
    protected static IdentityManager identityManager;
    public static void setIdentityManager(IdentityManager identityManager) {
        AuthenticationService.identityManager = identityManager;
    }

    public abstract Customer logIn(LoginRequest request);
    public abstract boolean signUp(SignUpRequest request);
}
