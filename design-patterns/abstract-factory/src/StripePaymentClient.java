import java.math.BigDecimal;

public class StripePaymentClient implements PaymentClient{
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("The stripe payment has been made: " + amount);
    }
}
