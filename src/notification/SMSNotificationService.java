package notification;

import person.User;

public class SMSNotificationService implements NotificationService {

    @Override
    public void sendNotification(User user, String message) {
        System.out.println("SMS: " + message);
        user.notify(message);
    }
}
