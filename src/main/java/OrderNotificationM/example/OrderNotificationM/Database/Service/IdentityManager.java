package OrderNotificationM.example.OrderNotificationM.Database.Service;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;
import lombok.Getter;
import lombok.Setter;

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
