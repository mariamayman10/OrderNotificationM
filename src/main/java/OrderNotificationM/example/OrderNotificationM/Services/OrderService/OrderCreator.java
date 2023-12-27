package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;

import java.util.List;

public class OrderCreator extends OrderService{
    public Order createOrder(String type){
        if(type == "simple"){
            return new SimpleOrder();
        }
        else if(type == "compound"){
            return new CompoundOrder();
        }
        else return null;
    }
}
