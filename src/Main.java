import fine.FixedPenaltyCalculator;
import fine.PenaltyCalculator;
import fine.ProgressivePenaltyCalculator;
import item.Book;
import management.ReservationManager;
import management.Statistics;
import notification.EmailNotificationService;
import notification.NotificationService;
import notification.PushNotificationService;
import person.Student;
import storage.Backup;
import storage.FileStorage;
import storage.InMemoryStorage;
import storage.Storage;

public class Main {
    public static void main(String[] args) {
        // Создаем пользователей
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Создаем книги
        Book book1 = new Book(1, "The Great Gatsby");
        Book book2 = new Book(2, "1984");
        Book book3 = new Book(3, "Moby Dick");

        // Создаем систему хранения данных
        Storage inMemoryStorage = new InMemoryStorage();
        Backup fileStorage = new FileStorage();

        // Создаем систему уведомлений
        NotificationService emailService = new EmailNotificationService();
        NotificationService pushService = new PushNotificationService();

        // Пользователи резервируют книги
        student1.reserveBook(book1);
        student2.reserveBook(book2);
        student1.reserveBook(book2);

        // Пользователи возвращают книги
        student1.returnBook(book1);
        student2.returnBook(book3);

        // Проверяем историю пользователя
        System.out.println("История Alice: ");
        student1.getHistory();
        System.out.println("История Bob: ");
        student2.getHistory();

        // Проверяем систему штрафов
        PenaltyCalculator fixedCalculator = new FixedPenaltyCalculator();
        PenaltyCalculator progressiveCalculator = new ProgressivePenaltyCalculator();

        long overdueDays = 7;
        double fine1 = fixedCalculator.calculateFine(overdueDays);
        double fine2 = progressiveCalculator.calculateFine(overdueDays);

        System.out.println("Штраф по фиксированной системе за " + overdueDays + " дней: " + fine1);
        System.out.println("Штраф по прогрессивной системе за " + overdueDays + " дней: " + fine2);

        // Пользователь оплачивает штраф
        student1.payFine(fine1);

        // Сохраняем данные

        // Уведомляем пользователей
        emailService.sendNotification(student2, "Ваша книга просрочена!");
        pushService.sendNotification(student1, "Новый доступный том: Moby Dick");

        // Проверяем авто-отмену резерваций
        ReservationManager reservationManager = new ReservationManager();
        reservationManager.checkExpiredReservations();

        // Отслеживание статистики популярных книг
        Statistics statistics = new Statistics();
        statistics.recordBorrow(book1);
        statistics.recordBorrow(book2);
        statistics.recordBorrow(book1);
        statistics.recordBorrow(book3);
        statistics.printStatistics();
    }
}
