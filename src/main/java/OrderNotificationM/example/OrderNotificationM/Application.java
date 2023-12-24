package OrderNotificationM.example.OrderNotificationM;
import OrderNotificationM.example.OrderNotificationM.Database.InMemoryDB;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        InMemoryDB inMemoryDB = new InMemoryDB();
        System.out.println(inMemoryDB.getProducts());
    }

}
