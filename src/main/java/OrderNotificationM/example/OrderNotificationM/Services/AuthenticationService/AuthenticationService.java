package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import org.springframework.stereotype.Service;

@Service
public abstract class AuthenticationService {
    public IdentityManager identityManager;
    public abstract Customer logIn(String email, String password);
    public abstract boolean signUp(SignUpRequest request);
}
