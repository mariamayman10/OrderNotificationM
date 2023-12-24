package OrderNotificationM.example.OrderNotificationM.Customer;

import OrderNotificationM.example.OrderNotificationM.Notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    List<Notification> notificationList = new ArrayList<>();
    private String name;
    private Region region;
    private double balance;
    private String password;
    private String email;
    private Language language;

}
