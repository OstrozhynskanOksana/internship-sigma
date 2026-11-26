package singletonenum;

import java.math.BigDecimal;

public class PriceCalculator {
    private BigDecimal total;

    public BigDecimal calculateTotal(BigDecimal price){
        BigDecimal taxRate = AppConfig.INSTANCE.getTaxRate();

        total = price.multiply(taxRate);
        return total;

    }

    public BigDecimal getTotal() {
        return total;
    }
}
