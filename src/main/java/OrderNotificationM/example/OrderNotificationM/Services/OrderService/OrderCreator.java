package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.*;

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
            order.setOrderID(currID);
            currID++;
            customer.getOrderList().add(order);
            return order;
        }
        else if (Objects.equals(type, "compound")) {
            order = new CompoundOrder();
            ((CompoundOrder)order).setSimpleOrderList(requestParser.getSimpleOrders());
            order.setStatus(OrderStatus.PLACED);
            FeesCalculationStrategy compoundFees = new CompoundFees();
            ((CompoundFees)compoundFees).setCustomerList(requestParser.getCustomers());
            order.setFeesCalculationStrategy(compoundFees);
            order.setProductList(requestParser.getTotalProducts());
            order.setOrderID(currID);
            currID++;
            int ind = 0;
            for(Customer c: requestParser.getCustomers()){
                if(ind == 0)c.getOrderList().add(order);
                else{
                    Order o = ((CompoundOrder) order).getSimpleOrderList().get(ind);
                    o.setStatus(OrderStatus.PLACED);
                    c.getOrderList().add(o);
                }
                ind++;
            }
            return order;
        }
        return null;
    }
}
