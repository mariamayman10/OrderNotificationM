package OrderNotificationM.example.OrderNotificationM.Order;

public class SimpleFees implements FeesCalculationStrategy{
    @Override
    public double calculateFees() {
        return 0;
    }
}
