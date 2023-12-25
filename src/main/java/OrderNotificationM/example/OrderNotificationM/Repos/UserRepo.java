package OrderNotificationM.example.OrderNotificationM.Repos;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UserRepo{
    @Getter
    static List<Customer> customerList = new ArrayList<>();
    public UserRepo(){
        customerList.add(new Customer("user1@gmail.com", "123"));
        customerList.add(new Customer("user2@gmail.com", "145"));
    }

}