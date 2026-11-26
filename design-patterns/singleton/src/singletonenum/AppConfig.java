package singletonenum;

import java.math.BigDecimal;

public enum AppConfig {
    INSTANCE;

    private final String currency;
    private final BigDecimal taxRate;

    private AppConfig(){
        this.currency = "USD";
        this.taxRate = new BigDecimal("0.20");
    }


    public String getCurrency() {
        return currency;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }
}
