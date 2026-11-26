import java.math.BigDecimal;

public interface PaymentClient {
    void pay(BigDecimal amount);
}
