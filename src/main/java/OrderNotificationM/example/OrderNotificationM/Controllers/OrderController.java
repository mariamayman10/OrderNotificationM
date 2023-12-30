package OrderNotificationM.example.OrderNotificationM.Controllers;

import OrderNotificationM.example.OrderNotificationM.Models.NotificationType;
import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Services.OrderService.*;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService orderService;
    @PostConstruct
    private void init(){
        orderService = new OrderCreator();
    }
    @PostMapping("/place")
    public String placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest){
        Order o = orderService.createOrder(placeOrderRequest);
        if(o != null){
            String email = placeOrderRequest.getData().get(0).getKey();
            NotificationController notificationController = new NotificationController();
            return notificationController.createNotification(NotificationType.ORDER_PLACED, o.getProductList(), email);
        }
        else return "Order couldn't be placed";
    }
    @PostMapping("/ship")
    public String shipOrder(@RequestBody ShipOrderRequest shipOrderRequest){
        Order shippedOrder = orderService.shipOrder(shipOrderRequest);
        if(shippedOrder != null){
            String ret = "";
            String email = shipOrderRequest.getEmail();
            NotificationController notificationController = new NotificationController();
            ret += shippedOrder.printOrder();
            ret += '\n';
            ret += notificationController.createNotification(NotificationType.ORDER_SHIPPED, shippedOrder.getProductList(), email);
            return ret;
        }
        else return "No such a placed order to ship";
    }
    @PostMapping("/cancel")
    public String cancelOrder(@RequestBody CancelOrderRequest cancelOrderRequest){
        boolean cancelledOrder = orderService.cancelOrder(cancelOrderRequest);
        if(cancelledOrder){
            return "Order has been cancelled successfully";
        }
        else return "Couldn't cancel order";
    }
    @GetMapping("/print")
    public String printOrder(@RequestBody PrintOrderRequest printOrderRequest){
        return orderService.printOrder(printOrderRequest);
    }
}