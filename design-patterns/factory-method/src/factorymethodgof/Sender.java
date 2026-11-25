package factorymethodgof;

public abstract class Sender {

    public void send(String message){
    Notification notification = createNotification();
    notification.send(message);
    }

    abstract Notification createNotification();


}
