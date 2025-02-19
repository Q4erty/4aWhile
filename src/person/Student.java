package person;

import item.LibraryItem;
import management.Reservation;
import management.UserHistory;

import java.util.ArrayList;
import java.util.List;

public class Student implements person.User, person.StudentAbility {

    private int id;

    private String name;

    private final List<LibraryItem> borrowedBooks = new ArrayList<>();

    private final List<Reservation> reservations = new ArrayList<>();

    private double fine;

    private final UserHistory history = new UserHistory();


    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void borrowBook(LibraryItem item) {
        if (item.isAvailable()) {
            item.getItem();
            borrowedBooks.add(item);
            history.addEntry(item, "borrowed");
            System.out.println(name + " borrowed " + item.getTitle());
        } else {
            System.out.println("Item is not available for borrowing.");
        }
    }

    public void reserveBook(LibraryItem item) {
        if (!item.isAvailable()) {
            Reservation reservation = new Reservation(this, item);
            reservations.add(reservation);
            item.setAvailable(false);
            System.out.println(name + " reserved " + item.getTitle());
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void returnBook(LibraryItem item) {
        LibraryItem itemToReturn = null;
        for (LibraryItem borrowed : borrowedBooks) {
            if (borrowed.getId() == item.getId()) {
                itemToReturn = borrowed;
                break;
            }
        }
        if (itemToReturn != null) {
            itemToReturn.returnItem();
            borrowedBooks.remove(itemToReturn);
            history.addEntry(itemToReturn, "returned");
            System.out.println(name + " returned " + itemToReturn.getTitle());
        } else {
            System.out.println("Item not found in borrowed items.");
        }
    }

    public void payFine(double amount) {
        fine -= amount;
    }

    @Override
    public void notify(String message) {
        System.out.println(name + " get norification: " + message);
    }

    public void getHistory() {
        history.getTransactions().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                ", reservations=" + reservations +
                ", fine=" + fine +
                ", history=" + history +
                '}';
    }
}
