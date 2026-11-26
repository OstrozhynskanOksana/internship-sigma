import java.math.BigDecimal;

public class StripeRefundClient implements RefundClient{
    @Override
    public void makeRefund(BigDecimal amount) {
        System.out.println("The stripe refund has been made: " + amount);
    }
}
