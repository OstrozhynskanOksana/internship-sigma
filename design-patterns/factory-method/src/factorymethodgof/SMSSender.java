package factorymethodgof;

public class SMSSender extends Sender {


    @Override
    Notification createNotification() {
        return new SMSNotification();
    }
}
