package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Models.*;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import lombok.Setter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
public class LocalAuthentication extends AuthenticationService {
    @Override
    public Customer logIn(String email, String password) {

        // Retrieve the customer from the identity manager
        Customer customer = identityManager.validate(email, password);

        // Generate JWT token
        String jwtToken = generateJwtToken(customer.getEmail());

        // Optionally, you can store the token in the Customer object or return it in some way
        customer.setJwtToken(jwtToken);

        return customer;
    }

    private String generateJwtToken(String email) {
        // Define JWT claims
       // String secretKey = "your-secret-key"; // Replace with a secure secret key
        long expirationTimeInMs = 3600000; // 1 hour

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTimeInMs))
                .compact();
    }
    @Override
    public boolean signUp(SignUpRequest request) {
        //data from the SignUpRequest
        String name = request.getName();
        String region = request.getRegion();
        double balance = request.getBalance();
        String password = request.getPassword();
        String email = request.getEmail();
        String language = request.getLanguage();
        String region_uppercase = region.toUpperCase();
        String language_uppercase = language.toUpperCase();
        Region regionEnum;
        Language languageEnum;
        if(!isExistRegion(region_uppercase)){
            return false;
        }
        else {
             regionEnum = Region.valueOf(region_uppercase);
        }
        if(!isVExistLanguage(language_uppercase)){
            return false;
        }
        else {
             languageEnum = Language.valueOf(language_uppercase);
        }

        if(identityManager.doesExist(email)!=null){
            return false;
        }
        // Validate inputs
        if (!isValidEmail(email)) {
            return false;
        }
        if (!isValidStrongPassword(password)) {
            return false;
        }

        Customer newCustomer = new Customer(email, password, name, regionEnum, balance, languageEnum);
        // Add the new customer to the list

        UserRepo.addCustomer(newCustomer);
        return true;
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Regular expression for a basic email format
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean isValidStrongPassword(String password) {
        // Check for minimum length
        if (password == null && password.length() < 8) {
            return false;
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        //if matches all cases
        return true;
    }

    private boolean isExistRegion(String region) {
        for (Region validRegion : Region.values()) {
            if (validRegion.name().equals(region)) {
                return true;
            }
        }
        return false;
    }

    private boolean isVExistLanguage(String language) {
        for (Language validLanguage : Language.values()) {
            if (validLanguage.name().equals(language)) {
                return true;
            }
        }
        return false;
    }
}


