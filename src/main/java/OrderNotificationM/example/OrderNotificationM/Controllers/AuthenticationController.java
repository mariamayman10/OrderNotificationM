package OrderNotificationM.example.OrderNotificationM.Controllers;
import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.*;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationService authenticationService;
    @PostConstruct
    private void init(){
        AuthenticationServiceC authenticationServiceC = new AuthenticationServiceC();
        authenticationService = authenticationServiceC.createAuthenticationService("local");
    }
    @PostMapping("/login")
    public Customer logIn(@RequestBody LoginRequest loginRequest) {
        return authenticationService.logIn(loginRequest);
    }
    @PostMapping("/signup")
    public boolean signUp(@RequestBody SignUpRequest SignUprequest) {
       return authenticationService.signUp(SignUprequest);
    }
}
