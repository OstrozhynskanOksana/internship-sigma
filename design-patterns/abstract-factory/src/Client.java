import java.math.BigDecimal;

public class Client {

    private final AbstractFactory type;


    public Client(AbstractFactory type) {
        this.type = type;
    }

    public void pay(BigDecimal amount){
        PaymentClient paymentClient = type.createPaymentClient();
        paymentClient.pay(amount);
    }

    public void makeRefund(BigDecimal amount){
        RefundClient refundClient = type.createRefundClient();
        refundClient.makeRefund(amount);
    }
}
