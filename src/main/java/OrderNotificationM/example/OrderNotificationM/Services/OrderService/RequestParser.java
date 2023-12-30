package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Models.Order;
import OrderNotificationM.example.OrderNotificationM.Models.Product;
import OrderNotificationM.example.OrderNotificationM.Models.Region;
import OrderNotificationM.example.OrderNotificationM.Repos.ProductRepo;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.DBService;
import OrderNotificationM.example.OrderNotificationM.Services.DBService.IdentityManager;
import lombok.Getter;

import java.util.*;

@Getter
public class RequestParser {
    private static IdentityManager identityManager;
    private List<Customer> customers = new ArrayList<>();
    private final List<SimpleOrder> simpleOrders = new ArrayList<>();
    private final Map<Product, Integer> totalProducts = new HashMap<>();

    public static void setIdentityManager(IdentityManager identityManager) {
        RequestParser.identityManager = identityManager;
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
            for (Map.Entry<String, Integer> entry: e.getValue().entrySet()){
                Product p = identityManager.getProduct(entry.getKey());
                productList.put(p, entry.getValue());
            }
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
                totalPrice += Objects.requireNonNull(identityManager.getProduct(a.getKey())).getPrice() * a.getValue();
                if(customerB < totalPrice)return false;
            }
            ind++;
        }
        return true;
    }
    private List<Customer> checkExistence(List<String> emails){
        List<Customer> users = new ArrayList<>();
        for (String email: emails){
            Customer c = identityManager.getCustomer(email);
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
                Product product = identityManager.getProduct(entry.getKey());
                if(product == null)return false;
                int quantity = entry.getValue();
                totalProducts.merge(product, quantity, Integer::sum);
            }
        }
        for (Map.Entry<Product, Integer> entry: totalProducts.entrySet()){
            int neededQ = entry.getValue();
            if(identityManager.getAvailableQuantity(entry.getKey()) < neededQ){
                return false;
            }
        }
        return true;
    }
}