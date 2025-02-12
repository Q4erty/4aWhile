package notification;

import person.User;

public interface NotificationService {

    void sendNotification(User user, String message);
}
