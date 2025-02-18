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

    private List<Reservation> reservations = new ArrayList<>();

    private double fine;

    private UserHistory history = new UserHistory();


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

    public void reserveBook(LibraryItem item) {
        if (!item.isReserved()) {
            Reservation reservation = new Reservation(this, item);
            reservations.add(reservation);
            item.setReserved(true);
            System.out.println(name + " reserved " + item.getTitle());
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void returnBook(LibraryItem item) {
        borrowedBooks.remove(item);
        history.addEntry(item, "returned");
    }

    public void payFine(double amount) {
        fine -= amount;
    }

    @Override
    public void notify(String message) {
        System.out.println(name + " get norification: " + message);
    }
}
