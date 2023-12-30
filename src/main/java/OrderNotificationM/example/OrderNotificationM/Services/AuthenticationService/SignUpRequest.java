package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Models.Language;
import OrderNotificationM.example.OrderNotificationM.Models.Region;
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
