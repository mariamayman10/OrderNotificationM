package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.OrderStatus;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
public class CompoundFees implements FeesCalculationStrategy{
    List<Customer> customerList;
    @Override
    public void calculateFees(Order order) {
        int index = 0;
        for(Order simple: ((CompoundOrder)order).getSimpleOrderList()){
            Map<Product, Integer> productList = simple.getProductList();
            double totalPrice = 0;
            for(Map.Entry<Product, Integer> e: productList.entrySet()){
                totalPrice += e.getKey().getPrice() * e.getValue();
            }
            simple.setStatus(OrderStatus.SHIPPED);
            this.customerList.get(index).setBalance(this.customerList.get(index).getBalance()-totalPrice);
            index++;
        }

    }
}
