package OrderNotificationM.example.OrderNotificationM.Order;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrder extends Order{
    List<SimpleOrder> simpleOrderList = new ArrayList<>();
    @Override
    public String printOrder() {
        return null;
    }
}
