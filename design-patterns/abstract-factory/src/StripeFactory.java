public class StripeFactory extends AbstractFactory{
    @Override
    public PaymentClient createPaymentClient() {
        return new StripePaymentClient();
    }

    @Override
    public RefundClient createRefundClient() {
        return new StripeRefundClient();
    }
}
