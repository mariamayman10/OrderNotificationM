package OrderNotificationM.example.OrderNotificationM.Order.Service;

import OrderNotificationM.example.OrderNotificationM.Order.Models.*;
import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class OrderCreator extends OrderService {
    @Override
    public Order createOrder(PlaceOrderRequest placeOrderRequest) {
        String type = placeOrderRequest.getType();
        RequestParser requestParser = new RequestParser();
        boolean canCreate = requestParser.parse(placeOrderRequest);
        if(!canCreate)return null;
        Order order;

        if (Objects.equals(type, "simple")) {
            Customer customer = requestParser.getCustomers().get(0);
            Map<Product, Integer> productList = requestParser.getTotalProducts();
            order = new SimpleOrder();
            order.setProductList(productList);
            order.setStatus(OrderStatus.PLACED);
            FeesCalculationStrategy simpleFees = new SimpleFees();
            ((SimpleFees)simpleFees).setCustomer(customer);
            order.setFeesCalculationStrategy(simpleFees);
            order.setProductList(requestParser.getTotalProducts());
            order.setOwner(customer);
            order.setOrderID(currID);
            currID++;
            LocalDateTime currentDateTime = LocalDateTime.now();
            order.setTimeStamp(Time.valueOf(currentDateTime.toLocalTime()));
            customer.getOrderList().add(order);
            return order;
        }
        else if (Objects.equals(type, "compound")) {
            order = new CompoundOrder();
            ((CompoundOrder)order).setSimpleOrderList(requestParser.getSimpleOrders());
            FeesCalculationStrategy compoundFees = new CompoundFees();
            ((CompoundFees)compoundFees).setCustomerList(requestParser.getCustomers());
            order.setFeesCalculationStrategy(compoundFees);
            order.setProductList(requestParser.getTotalProducts());
            int ind = 0;
            LocalDateTime currentDateTime = LocalDateTime.now();
            for(Customer c: requestParser.getCustomers()){
                Order o = ((CompoundOrder) order).getSimpleOrderList().get(ind);
                if(ind == 0){
                    order.setTimeStamp(Time.valueOf(currentDateTime.toLocalTime()));
                    order.setStatus(OrderStatus.PLACED);
                    order.setOrderID(currID);
                    order.setOwner(c);
                    o.setStatus(OrderStatus.PLACED);
                    o.setOrderID(currID);
                    o.setOwner(c);
                    o.setTimeStamp(Time.valueOf(currentDateTime.toLocalTime()));
                    c.getOrderList().add(order);
                }
                else{
                    o.setStatus(OrderStatus.PLACED);
                    o.setOrderID(currID);
                    o.setOwner(c);
                    o.setTimeStamp(Time.valueOf(currentDateTime.toLocalTime()));
                    c.getOrderList().add(o);
                }
                ind++;
            }
            currID++;
            return order;
        }
        return null;
    }
}
