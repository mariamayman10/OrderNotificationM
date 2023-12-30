package OrderNotificationM.example.OrderNotificationM.Services.AuthenticationService;

import OrderNotificationM.example.OrderNotificationM.Models.*;
import OrderNotificationM.example.OrderNotificationM.Repos.UserRepo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class LocalAuthentication extends AuthenticationService {
    @Override
    public Customer logIn(LoginRequest request) {
        return identityManager.validate(request.getEmail(), request.getPassword());
    }
    @Override
    public boolean signUp(SignUpRequest request) {
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
        if(!isExistRegion(region_uppercase))
            return false;
        else
            regionEnum = Region.valueOf(region_uppercase);
        if(!isVExistLanguage(language_uppercase))
            return false;
        else
            languageEnum = Language.valueOf(language_uppercase);

        if(identityManager.getCustomer(email)!=null)
            return false;
        if (!isValidEmail(email))
            return false;
        if (!isValidStrongPassword(password))
            return false;

        Customer newCustomer = new Customer(name, regionEnum, balance, password, email, languageEnum);
        UserRepo.getCustomerList().add(newCustomer);
        return true;
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
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


