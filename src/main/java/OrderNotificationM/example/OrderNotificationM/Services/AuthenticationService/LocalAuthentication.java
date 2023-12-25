package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Models.*;
import lombok.Setter;

import java.util.List;


public class LocalAuthentication extends AuthenticationService {
    @Override
    public Customer logIn(String email, String password) {
        return identityManager.validate(email, password);
    }
    @Override
    public boolean signUp() {
        // Implement the signUp method if needed.
        return true;
    }

}
