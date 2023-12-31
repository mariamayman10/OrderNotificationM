package OrderNotificationM.example.OrderNotificationM.Order.Models;

import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SimpleOrder extends Order {
    @Override
    public String printOrder() {
        String ret = "";
        ret += "Customer Name: ";
        ret += this.getOwner().getName();
        ret += '\n';
        ret += "OrderID: ";
        ret += this.getOrderID();
        ret += '\n';
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
