package singletongofdoublechecked;

import java.math.BigDecimal;

public class AppConfig {
    private static volatile AppConfig instance;
    private String currency;
    private BigDecimal taxRate;

    private AppConfig(){
        this.currency = "USD";
        this.taxRate = new BigDecimal("0.20");

    }

    public static AppConfig getInstance(){
        if(instance == null){
            synchronized (AppConfig.class) {
                if(instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public String getCurrency(){
        return currency;
    }

    public BigDecimal getTaxRate(){
        return taxRate;
    }


}
