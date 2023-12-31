package OrderNotificationM.example.OrderNotificationM.Order.Service;

import lombok.Getter;

@Getter
public class CancelOrderRequest {
    private int orderID;
    private String email;
}
