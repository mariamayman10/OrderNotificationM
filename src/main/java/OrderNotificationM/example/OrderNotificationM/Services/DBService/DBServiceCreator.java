package OrderNotificationM.example.OrderNotificationM.Services.DBService;

public class DBServiceCreator {
    public DBService createDBService(String type){
        if(type == "inMemory"){
            return new InMemoryService();
        }
        return null;
    }
}
