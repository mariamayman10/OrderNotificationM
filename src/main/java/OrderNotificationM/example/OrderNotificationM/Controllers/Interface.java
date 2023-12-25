package OrderNotificationM.example.OrderNotificationM.Controllers;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Interface {
    private Customer user;
    private final AuthenticationController authenticationController;
    private final DBController database;
    private final NotificationController NotificationController;
    private final OrderController orderController;

    public Interface(){
        user = new Customer();
        database = new DBController();
        authenticationController = new AuthenticationController(database.dbService);
        NotificationController = new NotificationController();
        orderController = new OrderController();
    }

    @PostMapping("/login")
    public Customer logIn(@RequestBody LoginRequest loginRequest) {
        String email = "", password = "";
        // parse JSON to strings
        email = loginRequest.getEmail();
        password = loginRequest.getPassword();
        user = authenticationController.logIn(email, password);
        if(user != null){

        }
        return user;
    }

}
