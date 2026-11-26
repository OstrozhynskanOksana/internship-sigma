import java.math.BigDecimal;

public class PayPalPaymentClient implements PaymentClient{
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("The payPal payment has been made: " + amount);
    }
}
