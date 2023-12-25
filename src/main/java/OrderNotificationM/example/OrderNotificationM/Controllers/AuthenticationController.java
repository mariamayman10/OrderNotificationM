package OrderNotificationM.example.OrderNotificationM.Controllers;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.AuthenticationService;
import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.AuthenticationServiceC;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;

import java.util.List;
public class AuthenticationController {
    AuthenticationService authenticationService;
    AuthenticationController(DBService dbService){
        AuthenticationServiceC authenticationServiceC = new AuthenticationServiceC();
        authenticationService = authenticationServiceC.createAuthenticationService("local");
        authenticationService.setDBIdentityManager(dbService);
    }
    public Customer logIn(String email, String password){
        return authenticationService.logIn(email, password);
    }
    public boolean signUp(){
        return false;
    }
}
