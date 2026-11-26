package factory;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email message: ");
        String emailMessage = scanner.nextLine();

        System.out.println("Enter your sms message: ");
        String smsMessage = scanner.nextLine();

        Sender sender = new Sender();
        Notification emailSender = sender.create(NotificationType.EMAIL);
        Notification smsSender = sender.create(NotificationType.SMS);

        emailSender.send(emailMessage);
        smsSender.send(smsMessage);


    }
}
