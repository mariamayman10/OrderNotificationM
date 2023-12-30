package OrderNotificationM.example.OrderNotificationM.Services.DBService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Map;

@Getter
@Setter
public class IdentityManager {
    private DBService dbService;
    public int getAvailableQuantity(Product product){
        return dbService.getAvailableQuantity(product);
    }
    public Product getProduct(String serialN){
        return dbService.getProduct(serialN);
    }
    public void updateProducts(Map<Product, Integer> products){
        dbService.updateProducts(products);
    }
    public Customer getCustomer(String email){
        return dbService.getCustomer(email);
    }
    public Customer validate(String email, String password){
        return dbService.validate(email, password);
    }
}
