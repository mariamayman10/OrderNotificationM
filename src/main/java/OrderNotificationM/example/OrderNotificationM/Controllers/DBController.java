package OrderNotificationM.example.OrderNotificationM.Controllers;

import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBServiceCreator;


public class DBController {
    DBService dbService;
    DBController(){
        DBServiceCreator dbServiceCreator = new DBServiceCreator();
        dbService = dbServiceCreator.createDBService("inMemory");
    }
}
