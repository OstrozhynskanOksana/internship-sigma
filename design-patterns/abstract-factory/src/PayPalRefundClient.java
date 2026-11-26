import java.math.BigDecimal;

public class PayPalRefundClient implements RefundClient{
    @Override
    public void makeRefund(BigDecimal amount) {
        System.out.println("The payPal refund has been made: " + amount);
    }
}
