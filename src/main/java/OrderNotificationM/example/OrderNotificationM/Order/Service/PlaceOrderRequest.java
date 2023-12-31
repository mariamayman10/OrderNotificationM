package OrderNotificationM.example.OrderNotificationM.Order.Service;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PlaceOrderRequest {
    String type;
    List<Map.Entry<String, Map<String, Integer>>> data;
}
