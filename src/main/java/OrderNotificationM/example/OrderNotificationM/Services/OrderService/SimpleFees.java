package OrderNotificationM.example.OrderNotificationM.Services.OrderService;

public class SimpleFees implements FeesCalculationStrategy{
    @Override
    public double calculateFees() {
        return 0;
    }
}
