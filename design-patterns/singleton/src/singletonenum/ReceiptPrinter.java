package singletonenum;

import java.math.BigDecimal;

public class ReceiptPrinter {
    public String printReceipt(BigDecimal total){
        String currency = AppConfig.INSTANCE.getCurrency();
        String price = String.valueOf(total);
        return price + " " + currency;
    }
}
