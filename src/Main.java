import item.Book;
import item.DVD;
import item.Magazine;
import person.Admin;
import person.Librarian;
import person.Student;
import storage.InMemoryStorage;
import storage.Storage;

public class Main {
    public static void main(String[] args) {
        Storage<Book> bookStorage = new InMemoryStorage<>();
        Storage<Magazine> magazineStorage = new InMemoryStorage<>();
        Storage<DVD> dvdStorage = new InMemoryStorage<>();

        Book book1 = new Book(1, "War and Peace");
        Book book2 = new Book(2, "The Great Gatsby");
        Book book3 = new Book(3, "Crime and Punishment");

        Magazine magazine1 = new Magazine(4, "National Geographic");
        Magazine magazine2 = new Magazine(5, "Wall-Street");

        DVD dvd1 = new DVD(6, "The Lord of the Rings");
        DVD dvd2 = new DVD(7, "Inception");

        Librarian librarian = new Librarian("Yerlan");
        Admin admin = new Admin("Aisulu");
        Student student = new Student("Nurzhan");

        librarian.addBook(bookStorage, book1);
        librarian.addBook(bookStorage, book2);
        librarian.addBook(bookStorage, book3);

        librarian.addBook(magazineStorage, magazine1);
        librarian.addBook(magazineStorage, magazine2);

        librarian.addBook(dvdStorage, dvd1);
        librarian.addBook(dvdStorage, dvd2);

        student.borrowBook(book1);
        student.borrowBook(book1);

        student.returnBook(book1);
        student.returnBook(book1);

        System.out.println("All books in storage:");
        bookStorage.findAll().forEach(book -> System.out.println(book.getTitle()));

        librarian.removeBook(bookStorage, 2);

        System.out.println("All books after removal:");
        bookStorage.findAll().forEach(book -> System.out.println(book.getTitle()));
    }
}
