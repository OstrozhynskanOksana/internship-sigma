package singletoneager;

import java.math.BigDecimal;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    private String currency;
    private BigDecimal taxRate;


    private AppConfig(){}

    public static AppConfig getInstance(){
        return INSTANCE;
    }

    public String getCurrency(){
        return currency;
    }

    public BigDecimal getTaxRate(){
        return taxRate;
    }

}
