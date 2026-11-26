import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the amount to pay: ");
        String amount1 = scanner.nextLine();

        System.out.println("Enter the amount to make refund: ");
        String amount2 = scanner.nextLine();

        Client payPalClient = new Client(new PayPalFactory());
        Client stripeClient = new Client(new StripeFactory());

        payPalClient.pay(new BigDecimal(amount1));
        stripeClient.makeRefund(new BigDecimal(amount2));


    }

}
