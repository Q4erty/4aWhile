package item;

import storage.Identifiable;

public class Book extends LibraryItem implements Identifiable {

    public Book(int id, String title) {
        super(id, title);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
