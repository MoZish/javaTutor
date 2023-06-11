package fact.it.restaurantappstart.model;

public class HappyHourPayment implements PaymentStrategy {
    public double getAppliedPrice(double currentPrice) {
        double appliedPrice = currentPrice * 0.8;
        return Math.round(appliedPrice * 100.0) / 100.0;
    }
}
