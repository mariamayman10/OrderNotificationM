package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

public class AuthenticationServiceC {
    public AuthenticationService createAuthenticationService(String type){
        if(type == "local")
            return new LocalAuthentication();
        return null;
    }
}
