package singletonedoublecheck;

import java.math.BigDecimal;

public class PriceCalculator{
private BigDecimal total;

    public BigDecimal calculateTotal(BigDecimal price){
        BigDecimal taxRate = AppConfig.getInstance().getTaxRate();

        total = price.multiply(taxRate);
        return total;

    }

    public BigDecimal getTotal() {
        return total;
    }
}
