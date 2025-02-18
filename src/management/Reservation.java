package management;

import item.LibraryItem;
import person.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private User user;

    private LibraryItem item;

    private LocalDate reservationDate;

    public Reservation(User user, LibraryItem item) {
        this.user = user;
        this.item = item;
        this.reservationDate = LocalDate.now();
    }

    public LibraryItem getItem() {
        return item;
    }

    public boolean isExpired() {
        return ChronoUnit.DAYS.between(reservationDate, LocalDate.now()) > 3;
    }

}
