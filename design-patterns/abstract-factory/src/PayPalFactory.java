public class PayPalFactory extends AbstractFactory{
    @Override
    public PaymentClient createPaymentClient() {
        return new PayPalPaymentClient();
    }

    @Override
    public RefundClient createRefundClient() {
        return new PayPalRefundClient();
    }
}
