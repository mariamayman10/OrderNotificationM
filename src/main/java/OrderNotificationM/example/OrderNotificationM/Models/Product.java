package OrderNotificationM.example.OrderNotificationM.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
public class Product {
    private String serialNumber;
    private String name;
    private String vendor;
    private double price;
    private Category category;
    private int quantity;
}
