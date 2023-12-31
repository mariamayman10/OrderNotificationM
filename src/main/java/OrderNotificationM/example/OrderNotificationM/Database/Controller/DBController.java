package OrderNotificationM.example.OrderNotificationM.Database.Controller;

import OrderNotificationM.example.OrderNotificationM.Notification.Service.NotificationService;
import OrderNotificationM.example.OrderNotificationM.Order.Service.OrderService;
import OrderNotificationM.example.OrderNotificationM.Customer.Service.AuthenticationService;
import OrderNotificationM.example.OrderNotificationM.Database.Service.*;
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
        DBManager DBManager = new DBManager();
        DBManager.setDbService(dbService);
        AuthenticationService.setIdentityManager(DBManager);
        OrderService.setIdentityManager(DBManager);
        NotificationService.setDBManager(DBManager);
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
