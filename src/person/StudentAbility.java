package person;

import item.LibraryItem;

public interface StudentAbility {

    void reserveBook(LibraryItem item);

    void returnBook(LibraryItem item);

    void payFine(double amount);
}
