package OrderNotificationM.example.OrderNotificationM.Order.Controller;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.NotificationType;
import OrderNotificationM.example.OrderNotificationM.Order.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Notification.Controller.NotificationController;
import OrderNotificationM.example.OrderNotificationM.Order.Service.*;
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
            String returnString = "";
            returnString += "Order ID: " + o.getOrderID() + '\n';
            String email = placeOrderRequest.getData().get(0).getKey();
            NotificationController notificationController = new NotificationController();
            returnString += notificationController.createNotification(NotificationType.ORDER_PLACED, o.getProductList(), email);
            return returnString;
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
    @PostMapping("/cancelShipment")
    public String cancelOrderShipment(@RequestBody CancelOrderRequest cancelOrderRequest){
        return orderService.cancelOrderShipment(cancelOrderRequest);
    }
    @PostMapping("/cancelPlacement")
    public String cancelOrderPlacement(@RequestBody CancelOrderRequest cancelOrderRequest){
        return orderService.cancelOrderPlacement(cancelOrderRequest);
    }
    @GetMapping("/print")
    public String printOrder(@RequestBody PrintOrderRequest printOrderRequest){
        return orderService.printOrder(printOrderRequest);
    }
}