package OrderNotificationM.example.OrderNotificationM.Repos;

import OrderNotificationM.example.OrderNotificationM.Models.Customer;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo{
    @Getter
    static List<Customer> customerList = new ArrayList<>();

    public static void addCustomer(Customer newCustomer) {
        customerList.add(newCustomer);
    }

}