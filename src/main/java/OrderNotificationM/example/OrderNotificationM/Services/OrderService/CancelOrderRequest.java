package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import lombok.Getter;

@Getter
public class CancelOrderRequest {
    private int orderID;
    private String email;
}
