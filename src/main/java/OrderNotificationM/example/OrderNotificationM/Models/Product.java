package OrderNotificationM.example.OrderNotificationM.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String serialNumber;
    private String name;
    private String vendor;
    private double price;
    private Category category;
}
