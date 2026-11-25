package factorymethodgof;

public class EmailSender extends Sender {


    @Override
    Notification createNotification() {
        return new EmailNotification();
    }
}
