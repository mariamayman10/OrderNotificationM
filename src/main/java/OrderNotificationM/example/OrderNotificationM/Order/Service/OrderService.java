package OrderNotificationM.example.OrderNotificationM.Order.Service;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Order.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Order.Models.OrderStatus;
import OrderNotificationM.example.OrderNotificationM.Database.Service.IdentityManager;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
@Setter
@Service
public abstract class OrderService {
    private static IdentityManager identityManager;
    static int currID = 0;

    public static void setIdentityManager(IdentityManager identityManager) {
        RequestParser.setIdentityManager(identityManager);
        OrderService.identityManager = identityManager;
    }

    public abstract Order createOrder(PlaceOrderRequest placeOrderRequest);
    public Order shipOrder(ShipOrderRequest shipOrderRequest){
        String email = shipOrderRequest.getEmail();
        Customer c = identityManager.getCustomer(email);
        if(c == null)return null;
        for(Order o: c.getOrderList()){
            if(o.getStatus().name().equals("PLACED")){
                o.getFeesCalculationStrategy().calculateFees(o);
                o.setStatus(OrderStatus.SHIPPED);
                return o;
            }
        }
        return null;
    }
    public boolean cancelOrder(CancelOrderRequest cancelOrderRequest){
        String email = cancelOrderRequest.getEmail();
        int orderId = cancelOrderRequest.getOrderID();
        Customer c = identityManager.getCustomer(email);
        if(c != null){
            for(Order order: c.getOrderList()){
                if(order.getOrderID() == orderId && order.getStatus() == OrderStatus.SHIPPED){
                    LocalDateTime currentTime = LocalDateTime.now();
                    LocalDateTime creationTime = order.getTimeStamp().toLocalTime().atDate(currentTime.toLocalDate());
                    Duration duration = Duration.between(creationTime, currentTime);
                    // cancel if duration didn't exceed 10 minutes
                    if(duration.getSeconds() < 600){
                        identityManager.updateProducts(order.getProductList());
                        c.setBalance(order.getTotalPrice());
                        c.getOrderList().remove(order);
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public String printOrder(PrintOrderRequest printOrderRequest){
        int orderID = printOrderRequest.getOrderId();
        String email = printOrderRequest.getEmail();
        String ret;
        if(orderID > currID)return "Wrong Order ID";
        Customer c = identityManager.getCustomer(email);
        for (Order o: c.getOrderList()){
            if(o.getOrderID() == orderID){
                ret = o.printOrder();
                return ret;
            }
        }
        return "You don't have such an order";
    }

}
