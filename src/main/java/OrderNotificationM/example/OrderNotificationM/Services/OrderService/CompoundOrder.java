package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Order;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrder extends Order {
    List<SimpleOrder> simpleOrderList = new ArrayList<>();
    @Override
    public String printOrder() {
        StringBuilder response = new StringBuilder();
        for(SimpleOrder simpleOrder:simpleOrderList){
            response.append(simpleOrder.printOrder());
        }
        return String.valueOf(response);
    }
}
