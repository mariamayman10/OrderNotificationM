package OrderNotificationM.example.OrderNotificationM.Controllers;
import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.AuthenticationService;
import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.AuthenticationServiceC;
import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.LoginRequest;
import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.SignUpRequest;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthenticationController {
    AuthenticationService authenticationService;
    AuthenticationController(){
        AuthenticationServiceC authenticationServiceC = new AuthenticationServiceC();
        authenticationService = authenticationServiceC.createAuthenticationService("local");
    }
    @PostMapping("/login")
    public Customer logIn(@RequestBody LoginRequest loginRequest){
        String email = "", password = "";
        email = loginRequest.getEmail();
        password = loginRequest.getPassword();
        Customer user = authenticationService.logIn(email, password);
        if(user != null){
            return user;
        }
        return new Customer("a","123");
    }
    @PostMapping("/signup")
    public boolean signUp(@RequestBody SignUpRequest request) {
        return authenticationService.signUp(request);
    }
}
