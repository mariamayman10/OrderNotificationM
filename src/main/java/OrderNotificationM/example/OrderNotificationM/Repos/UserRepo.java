package OrderNotificationM.example.OrderNotificationM.Repos;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class UserRepo{
    @Getter
    private static List<Customer> customerList = new ArrayList<>();
}