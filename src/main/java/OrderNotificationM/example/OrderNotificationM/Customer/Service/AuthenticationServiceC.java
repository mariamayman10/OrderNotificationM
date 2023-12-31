package OrderNotificationM.example.OrderNotificationM.Customer.Service;

public class AuthenticationServiceC {
    public AuthenticationService createAuthenticationService(String type){
        if(type == "local")
            return new LocalAuthentication();
        return null;
    }
}
