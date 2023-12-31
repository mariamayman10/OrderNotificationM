package OrderNotificationM.example.OrderNotificationM.Customer.Service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequest {
    private String name;
    private String region;
    private double balance;
    private String password;
    private String email;
    private String language;

}
