package OrderNotificationM.example.OrderNotificationM.Order.Service;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Order.Models.CompoundOrder;
import OrderNotificationM.example.OrderNotificationM.Order.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Order.Models.OrderStatus;
import OrderNotificationM.example.OrderNotificationM.Database.Service.DBManager;
import OrderNotificationM.example.OrderNotificationM.Order.Models.SimpleOrder;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

// cancel problem
@Setter
@Service
public abstract class OrderService {
    private static DBManager DBManager;
    static int currID = 0;

    public static void setIdentityManager(DBManager DBManager) {
        RequestParser.setDBManager(DBManager);
        OrderService.DBManager = DBManager;
    }

    public abstract Order createOrder(PlaceOrderRequest placeOrderRequest);
    public Order shipOrder(ShipOrderRequest shipOrderRequest){
        String email = shipOrderRequest.getEmail();
        Customer c = DBManager.getCustomer(email);
        if(c == null)return null;
        for(Order o: c.getOrderList()){
            if(o.getStatus().name().equals("PLACED")){
                o.getFeesCalculationStrategy().calculateFees(o);
                o.setStatus(OrderStatus.SHIPPED);
                LocalDateTime currentDateTime = LocalDateTime.now();
                o.setTimeStamp(Time.valueOf(currentDateTime.toLocalTime()));
                return o;
            }
        }
        return null;
    }
    public String cancelOrderShipment(CancelOrderRequest cancelOrderRequest){
        String email = cancelOrderRequest.getEmail();
        int orderId = cancelOrderRequest.getOrderId();
        Customer c = DBManager.getCustomer(email);
        if(c != null){
            for(Order order: c.getOrderList()){
                if(order.getOrderID() == orderId && order.getStatus() == OrderStatus.SHIPPED){
                    LocalDateTime currentTime = LocalDateTime.now();
                    LocalDateTime shippedTime = order.getTimeStamp().toLocalTime().atDate(currentTime.toLocalDate());
                    Duration duration = Duration.between(shippedTime, currentTime);
                    // cancel if duration didn't exceed 3 minutes
                    if(duration.getSeconds() < 70){
                        cancel(orderId, order);
                        return "Order shipment cancelled successfully";
                    }
                    else return "Time is out can't cancel";
                }
            }
            return "No such an order to cancel";
        }
        return "Invalid email";
    }
    public String printOrder(PrintOrderRequest printOrderRequest){
        int orderID = printOrderRequest.getOrderId();
        String email = printOrderRequest.getEmail();
        String ret;
        if(orderID > currID)return "Wrong Order ID";
        Customer c = DBManager.getCustomer(email);
        for (Order o: c.getOrderList()){
            if(o.getOrderID() == orderID){
                ret = o.printOrder();
                return ret;
            }
        }
        return "You don't have such an order";
    }

    public String cancelOrderPlacement(CancelOrderRequest cancelOrderRequest) {
        String email = cancelOrderRequest.getEmail();
        int orderId = cancelOrderRequest.getOrderId();
        Customer c = DBManager.getCustomer(email);
        if(c != null){
            for(Order order: c.getOrderList()){
                if(order.getOrderID() == orderId && order.getStatus() == OrderStatus.PLACED){
                    LocalDateTime currentTime = LocalDateTime.now();
                    LocalDateTime shippedTime = order.getTimeStamp().toLocalTime().atDate(currentTime.toLocalDate());
                    Duration duration = Duration.between(shippedTime, currentTime);
                    // cancel if duration didn't exceed 3 minutes
                    if(duration.getSeconds() < 70){
                        cancel(orderId, order);
                        return "Order placement cancelled successfully";
                    }
                    else{
                        return "Time is out can't cancel";
                    }
                }
            }
            return "No such an order to cancel";
        }
        return "Invalid email";
    }
    private void cancel(int orderId, Order order){
        DBManager.updateProducts(order.getProductList());
        // if order is compound order we need to remove it from other customers
        for(Customer customer: DBManager.getCustomers()){
            for(Order o: customer.getOrderList()){
                if(o.getOrderID() == orderId){
                    if(o.getTotalPrice() == -1){
                        List<SimpleOrder> list = ((CompoundOrder)o).getSimpleOrderList();
                        customer.setBalance(customer.getBalance() + list.get(0).getTotalPrice());
                    }
                    else
                        customer.setBalance(customer.getBalance() + o.getTotalPrice());
                    customer.getOrderList().remove(o);
                    break;
                }
            }
        }
    }
}
