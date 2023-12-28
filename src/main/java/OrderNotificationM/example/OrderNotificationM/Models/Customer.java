package OrderNotificationM.example.OrderNotificationM.Models;

import OrderNotificationM.example.OrderNotificationM.Models.Notification;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Customer {
    List<Notification> notificationList = new ArrayList<>();
    private String name;
    private Region region;
    private double balance;
    private String password;
    private String email;
    private Language language;
    private String jwtToken;


    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public  Customer(String email, String password, String name, Region region, double balance, Language language){
        this.email = email;
        this.password = password;
        this.name = name;
        this.region = region;
        this.balance = balance;
        this.language = language;
    }
    public Customer(){}
    public Language getLanguage(){return this.language;}

}
