package singletonholder;

import java.math.BigDecimal;

public class AppConfig {
    private String currency;
    private BigDecimal taxRate;

    private AppConfig(){
        this.currency = "USD";
        this.taxRate = new BigDecimal("0.20");
    }

    private static final class Holder{
        private static final AppConfig INSTANCE = new AppConfig();

    }

    public static AppConfig getInstance(){
        return Holder.INSTANCE;
    }

    public String getCurrency(){
        return currency;
    }

    public BigDecimal getTaxRate(){
        return taxRate;
    }

}
