package notification;

import person.User;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Email: " + message);
        user.notify(message);
    }
}
