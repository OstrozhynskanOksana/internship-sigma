package singletongofdoublechecked;

import java.math.BigDecimal;

public class Main {
    static void main(String[] args) {

        PriceCalculator priceCalculator = new PriceCalculator();
        BigDecimal total = priceCalculator.calculateTotal(new BigDecimal("230"));
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        String receipt = receiptPrinter.printReceipt(total);

        System.out.printf(receipt);
    }
}