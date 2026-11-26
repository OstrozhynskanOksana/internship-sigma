package factory;

public class Sender {

    public Notification create(NotificationType type){
        return switch (type){
        case EMAIL -> new EmailNotification();
        case SMS -> new SMSNotification();
        };
    }
}
