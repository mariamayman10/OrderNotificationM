package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.IdentityManager;
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
