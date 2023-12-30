package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SimpleOrder extends Order {
    @Override
    public String printOrder() {
        String ret = "";
        for(Map.Entry<Product, Integer>entry: getProductList().entrySet()){
         ret += "Product: ";
         ret += entry.getKey().getName();
         ret += " ";
         ret += "Quantity: ";
         ret += entry.getValue();
         ret += '\n';
     }
        return ret;
    }
}
