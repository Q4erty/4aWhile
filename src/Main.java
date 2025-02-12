import item.Book;
import notification.EmailNotificationService;
import notification.NotificationService;
import person.Librarian;
import person.Student;
import storage.InMemoryStorage;
import storage.Storage;

public class Main {
    public static void main(String[] args) {
        Storage storage = new InMemoryStorage();
        NotificationService emailService = new EmailNotificationService();

        Student student = new Student("Иван");
        Librarian librarian = new Librarian("Мария");

        Book book = new Book("1", "1984");
        librarian.addBook(storage, book);

        student.borrowBook(book);
        student.returnBook(book);

        emailService.sendNotification(student, "Возврат книги подтвержден.");
    }
}
