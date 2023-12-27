package OrderNotificationM.example.OrderNotificationM.Controllers;

import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Services.OrderService.OrderCreator;
import OrderNotificationM.example.OrderNotificationM.Services.OrderService.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    OrderService orderService;
    OrderController(){
        orderService = new OrderCreator();
    }
    @PostMapping("/simpleOrder")
    public void placeSimpleOrder(@RequestBody List<Product> productList){
        orderService.createOrder("simple");
    }
    @PostMapping("/complexOrder")
    public void placeComplexOrder(@RequestBody List<Product> productList){
        orderService.createOrder("compound");
    }
}
