package OrderNotificationM.example.OrderNotificationM.Order.Service;

import lombok.Getter;

@Getter
public class PrintOrderRequest {
    private int orderId;
    private String email;
}
