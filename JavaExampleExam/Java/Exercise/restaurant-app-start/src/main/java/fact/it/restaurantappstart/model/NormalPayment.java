package fact.it.restaurantappstart.model;

public class NormalPayment implements PaymentStrategy{
    public double getAppliedPrice(double currentPrice){
        return currentPrice;
    }
}
