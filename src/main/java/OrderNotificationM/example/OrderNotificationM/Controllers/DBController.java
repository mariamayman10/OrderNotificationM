package OrderNotificationM.example.OrderNotificationM.Controllers;

import OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService.AuthenticationService;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBServiceCreator;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.IdentityManager;
import OrderNotificationM.example.OrderNotificationM.Services.NotificationService.NotificationService;
import OrderNotificationM.example.OrderNotificationM.Services.OrderService.OrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class DBController {
    DBService dbService;
    @PostConstruct
    private void init(){
        DBServiceCreator dbServiceCreator = new DBServiceCreator();
        dbService = dbServiceCreator.createDBService("inMemory");
        IdentityManager identityManager = new IdentityManager();
        identityManager.setDbService(dbService);
        AuthenticationService.setIdentityManager(identityManager);
        OrderService.setIdentityManager(identityManager);
        NotificationService.setIdentityManager(identityManager);
    }
    @GetMapping("/products")
    public String getProducts(){
        return dbService.getStringProducts();
    }
    @GetMapping("/notifiedCustomer")
    public String getMostNotifiedCustomer(){
        return dbService.mostNotifiedCustomer();
    }
    @GetMapping("/usedTemplate")
    public String getMostUsedTemplate(){
        return dbService.mostUsedTemplate();
    }
    @GetMapping("/notifications")
    public String getNotificationQueue(){
        return dbService.getStringNotificationQueue();
    }
}
