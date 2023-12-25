package OrderNotificationM.example.OrderNotificationM.Models;

import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Notification> notificationList = new ArrayList<>();
    private String name;
    private Region region;
    private double balance;
    @Getter
    private String password;
    @Getter
    private String email;
    private Language language;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Customer(){}

}
