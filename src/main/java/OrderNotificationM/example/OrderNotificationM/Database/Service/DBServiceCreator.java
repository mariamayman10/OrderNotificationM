package OrderNotificationM.example.OrderNotificationM.Database.Service;

public class DBServiceCreator {
    public DBService createDBService(String type){
        if(type == "inMemory"){
            return new InMemoryService();
        }
        return null;
    }
}
