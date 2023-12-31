package OrderNotificationM.example.OrderNotificationM.Order.Service;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Order.Models.*;
import OrderNotificationM.example.OrderNotificationM.Database.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Customer.Models.Region;
import OrderNotificationM.example.OrderNotificationM.Database.Service.DBManager;

import lombok.Getter;

import java.util.*;

@Getter
public class RequestParser {
    private static DBManager DBManager;
    private List<Customer> customers = new ArrayList<>();
    private final List<SimpleOrder> simpleOrders = new ArrayList<>();
    private final Map<Product, Integer> totalProducts = new HashMap<>();

    public static void setDBManager(DBManager DBManager) {
        RequestParser.DBManager = DBManager;
    }

    public boolean parse(PlaceOrderRequest placeOrderRequest){
        String type = placeOrderRequest.getType();
        if(!Objects.equals(type, "simple") && !Objects.equals(type, "compound"))return false;
        List<Map.Entry<String, Map<String, Integer>>> data = placeOrderRequest.getData();
        List<Map<String, Integer>> products = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        for(Map.Entry<String, Map<String, Integer>> e: data){
           emails.add(e.getKey());
           products.add(e.getValue());
        }
        customers = checkExistence(emails);
        if(customers == null)return false;
        boolean productB = checkAvailability(products);
        if(!productB) return false;
        boolean balanceE = isEnough(customers, products);
        if(!balanceE)return false;
        //create simple order for each customer
        for(Map.Entry<String, Map<String, Integer>> e: data){
            Order simpleOrder = new SimpleOrder();
            Map<Product, Integer> productList = new HashMap<>();
            double totalPrice = 0;
            for (Map.Entry<String, Integer> entry: e.getValue().entrySet()){
                Product p = DBManager.getProduct(entry.getKey());
                productList.put(p, entry.getValue());
                totalPrice += p.getPrice() * entry.getValue();
            }
            simpleOrder.setTotalPrice(totalPrice);
            simpleOrder.setProductList(productList);
            simpleOrders.add((SimpleOrder) simpleOrder);
        }
        // update quantity of products
        for (Map.Entry<Product, Integer> entry: totalProducts.entrySet())
            entry.getKey().setQuantity(entry.getKey().getQuantity() - entry.getValue());
        return true;
    }
    private boolean isEnough(List<Customer> customers, List<Map<String, Integer>> products){
        int ind = 0;
        for (Customer c: customers){
            double customerB = c.getBalance(), totalPrice = 0;
            for(Map.Entry<String, Integer> a: products.get(ind).entrySet()){
                totalPrice += Objects.requireNonNull(DBManager.getProduct(a.getKey())).getPrice() * a.getValue();
                if(customerB < totalPrice)return false;
            }
            ind++;
        }
        return true;
    }
    private List<Customer> checkExistence(List<String> emails){
        List<Customer> users = new ArrayList<>();
        for (String email: emails){
            Customer c = DBManager.getCustomer(email);
            if(c == null) return null;
            users.add(c);
        }
        Region region = users.get(0).getRegion();
        for(Customer c: users){
            if(c.getRegion() != region)return null;
        }
        return users;
    }
    private boolean checkAvailability(List<Map<String, Integer>> products){
        for(Map<String, Integer> mp: products){
            for (Map.Entry<String, Integer> entry: mp.entrySet()){
                Product product = DBManager.getProduct(entry.getKey());
                if(product == null)return false;
                int quantity = entry.getValue();
                totalProducts.merge(product, quantity, Integer::sum);
            }
        }
        for (Map.Entry<Product, Integer> entry: totalProducts.entrySet()){
            int neededQ = entry.getValue();
            if(DBManager.getAvailableQuantity(entry.getKey()) < neededQ){
                return false;
            }
        }
        return true;
    }
}