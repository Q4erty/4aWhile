package notification;

import person.User;

public class PushNotificationService implements NotificationService {

    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Push Notification: " + message);
    }
}
