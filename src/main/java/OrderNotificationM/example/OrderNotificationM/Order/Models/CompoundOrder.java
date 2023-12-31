package OrderNotificationM.example.OrderNotificationM.Order.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class CompoundOrder extends Order {
    private List<SimpleOrder> simpleOrderList = new ArrayList<>();
    @Override
    public String printOrder() {
        String ret = "";
        for(SimpleOrder simpleOrder: simpleOrderList){
            ret += simpleOrder.printOrder();
            ret += '\n';
        }
        return ret;
    }
}
