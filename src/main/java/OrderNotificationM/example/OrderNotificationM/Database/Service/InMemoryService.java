package OrderNotificationM.example.OrderNotificationM.Database.Service;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Notification.Models.NotificationTemplate;
import OrderNotificationM.example.OrderNotificationM.Notification.Repo.TemplateRepo;
import OrderNotificationM.example.OrderNotificationM.Customer.Repo.CustomerRepo;
import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import OrderNotificationM.example.OrderNotificationM.Database.Repo.*;
import OrderNotificationM.example.OrderNotificationM.Database.Models.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class InMemoryService extends DBService{
    @Override
    public String getStringProducts() {
        StringBuilder productsInfo = new StringBuilder();
        for (Map.Entry<Category, List<Product>> entry : getProductRepo().getProductList().entrySet()) {
            Category category = entry.getKey();
            List<Product> products = entry.getValue();

            productsInfo.append("Category: ").append(category).append("\n");

            for (Product product : products) {
                productsInfo.append("Serial Number: ").append(product.getSerialNumber())
                        .append(", Name: ").append(product.getName())
                        .append(", Vendor: ").append(product.getVendor())
                        .append(", Price: ").append(product.getPrice())
                        .append(", Available Quantity: ").append(product.getQuantity())
                        .append("\n");
            }
            productsInfo.append("\n");
        }
        return productsInfo.toString();
    }
    @Override
    public String mostNotifiedCustomer(){
        Customer ret = CustomerRepo.getCustomerList().get(0);
        for(Customer c: CustomerRepo.getCustomerList()){
            if(c.getNotificationList().size() > ret.getNotificationList().size())
                ret = c;
        }
        return ret.getEmail();
    }
    @Override
    public String mostUsedTemplate(){
        NotificationTemplate ret = new NotificationTemplate();
        int max = 0;
        for(Map.Entry<NotificationTemplate, Integer>entry: TemplateRepo.getTemplateCount().entrySet()){
            if(entry.getValue() > max){
                ret = entry.getKey();
                max = entry.getValue();
            }
        }
        return ret.getContent();
    }
    @Override
    public int getAvailableQuantity(Product product){
        for (Map.Entry<Category, List<Product>> entry: productRepo.getProductList().entrySet()){
            for(Product p: entry.getValue()){
                if(p == product)return p.getQuantity();
            }
        }
        return 0;
    }
    @Override
    public Product getProduct(String serialN){
        for (Map.Entry<Category, List<Product>> entry: productRepo.getProductList().entrySet()){
            for(Product p: entry.getValue()){
                if(p.getSerialNumber() == serialN)return p;
            }
        }
        return null;
    }
    @Override
    public void updateProducts(Map<Product, Integer> products){
        for(Map.Entry<Product, Integer> entry: products.entrySet()){
            for(Map.Entry<Category, List<Product>> entry1: productRepo.getProductList().entrySet()){
                if(entry.getKey().getCategory() == entry1.getKey()){
                    for(Product p: entry1.getValue()){
                        if(p.getSerialNumber() == entry.getKey().getSerialNumber()){
                            p.setQuantity(p.getQuantity() + entry.getValue());
                        }
                    }
                }
            }
        }
    }
    @Override
    public Customer getCustomer(String email){
        for(Customer c: userRepo.getCustomerList()){
            if(Objects.equals(c.getEmail(), email))return c;
        }
        return null;
    }
    @Override
    public Customer validate(String email, String password){
        for (Customer customer : userRepo.getCustomerList()) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public String getStringNotificationQueue() {
        StringBuilder notifications = new StringBuilder();
        for (Notification n : getNotificationQueue()) {
            notifications.append(n.getFinalContent());
            notifications.append("\n");
        }
        return notifications.toString();
    }
}
