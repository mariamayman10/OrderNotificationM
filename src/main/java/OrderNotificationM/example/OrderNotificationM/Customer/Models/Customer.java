package OrderNotificationM.example.OrderNotificationM.Customer.Models;

import OrderNotificationM.example.OrderNotificationM.Notification.Models.Notification;
import OrderNotificationM.example.OrderNotificationM.Order.Models.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    List<Order> orderList = new ArrayList<>();
    List<Notification> notificationList = new ArrayList<>();
    private String name;
    private Region region;
    private double balance;
    private String password;
    private String email;
    private Language language;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Customer(String name, Region region, double balance, String password, String email, Language lang){
        this.name = name;
        this.region = region;
        this.balance = balance;
        this.password = password;
        this.email = email;
        this.language = lang;
    }
}
