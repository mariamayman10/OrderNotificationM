package OrderNotificationM.example.OrderNotificationM.Customer.Repo;

import OrderNotificationM.example.OrderNotificationM.Customer.Models.Customer;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo{
    @Getter
    private static List<Customer> customerList = new ArrayList<>();
}