import fine.FixedPenaltyCalculator;
import fine.PenaltyCalculator;
import fine.ProgressivePenaltyCalculator;
import item.Book;
import item.DVD;
import item.LibraryItem;
import item.Magazine;
import management.Reservation;
import management.ReservationManager;
import management.Statistics;
import notification.EmailNotificationService;
import notification.NotificationService;
import notification.PushNotificationService;
import notification.SMSNotificationService;
import person.Admin;
import person.Librarian;
import person.Student;
import storage.*;

public class Main {
    public static void main(String[] args) {
        // ========== Инициализация систем ==========
        // Хранилища
        InMemoryStorage<LibraryItem> inMemoryStorage = new InMemoryStorage<>();
        DatabaseStorage userDatabase = new DatabaseStorage();
        Backup fileStorage = new FileStorage();

        // Уведомления
        NotificationService emailService = new EmailNotificationService();
        NotificationService pushService = new PushNotificationService();
        NotificationService smsService = new SMSNotificationService();

        // Штрафные калькуляторы
        PenaltyCalculator fixedCalculator = new FixedPenaltyCalculator();
        PenaltyCalculator progressiveCalculator = new ProgressivePenaltyCalculator();

        // Менеджер резерваций
        ReservationManager reservationManager = new ReservationManager();

        // ========== Создание сущностей ==========
        // Пользователи
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Admin admin = new Admin("Chief Admin");
        Librarian librarian = new Librarian("Main Librarian");

        // Книги и другие материалы
        Book book1 = new Book(1, "The Great Gatsby");
        DVD dvd1 = new DVD(2, "Matrix DVD");
        Magazine magazine1 = new Magazine(3, "National Geographic");

        // ========== Тестирование функционала ==========
        // 1. Администратор управляет пользователями
        admin.addUser(userDatabase, student1);
        admin.addUser(userDatabase, student2);
        admin.watchUsers(inMemoryStorage); // Демонстрация полиморфизма

        // 2. Библиотекарь управляет коллекцией
        librarian.addBook(inMemoryStorage, book1);
        librarian.addBook(inMemoryStorage, dvd1); // Проверка работы с разными типами
        librarian.addBook(inMemoryStorage, magazine1);
        librarian.removeBook(inMemoryStorage, 2);

        // 3. Работа с резервациями
        student1.reserveBook(book1);
        student2.reserveBook(book1); // Попытка резервации занятой книги
        reservationManager.addReservation(new Reservation(student1, book1));

        // 4. Возврат и история операций
        student1.borrowBook(book1); // Alice borrows
        student1.returnBook(book1); // Alice returns

        // 5. Тестирование всех типов уведомлений
        emailService.sendNotification(student1, "Проверка email-уведомления");
        pushService.sendNotification(student2, "Проверка push-уведомления");
        smsService.sendNotification(student1, "Проверка SMS-уведомления");

        // 6. Штрафные системы
        System.out.println("\n=== Тестирование штрафов ===");
        long[] testDays = {3, 7, 10};
        for (long days : testDays) {
            System.out.printf("Фиксированный штраф за %d дней: %.1f руб.%n",
                    days, fixedCalculator.calculateFine(days));
            System.out.printf("Прогрессивный штраф за %d дней: %.1f руб.%n%n",
                    days, progressiveCalculator.calculateFine(days));
        }

        // 7. Статистика использования
        Statistics stats = new Statistics();
        stats.recordBorrow(book1);
        stats.recordBorrow(book1);
        stats.printStatistics();

        // 8. Работа с бэкапами
        System.out.println("\n=== Тестирование бэкапов ===");
        fileStorage.saveData(inMemoryStorage, userDatabase);
        fileStorage.loadData();

        // 9. Автоматическая отмена резерваций
        System.out.println("\n=== Автоотмена резерваций ===");
        reservationManager.checkExpiredReservations();
        System.out.println("Статус книги после отмены: " + book1.isAvailable());

        // 10. Тестирование специальных сценариев
        System.out.println("\n=== Специальные тесты ===");
        // Попытка вернуть не бракованную книгу
        book1.returnItem();
        // Просмотр истории пользователя
        System.out.println("\nИстория Alice:");
        student1.getHistory();
    }
}