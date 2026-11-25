package factorymethodgof;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email message: ");
        String emailMessage = scanner.nextLine();

        System.out.println("Enter your sms message: ");
        String smsMessage = scanner.nextLine();

        Sender emailSender = new EmailSender();
        emailSender.send(emailMessage);

        Sender smsSender = new SMSSender();
        smsSender.send(smsMessage);



    }
}