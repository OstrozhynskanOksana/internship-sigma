public abstract class AbstractFactory {

    public abstract PaymentClient createPaymentClient();
    public abstract RefundClient createRefundClient();
}
