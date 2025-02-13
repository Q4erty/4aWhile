package person;

import item.LibraryItem;
import storage.Storage;

public class Librarian implements person.User {

    private int id;

    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public <T extends LibraryItem> void addBook(Storage<T> storage, T item) {
        storage.save(item);
    }

    public <T extends LibraryItem> void removeBook(Storage<T> storage, int id) {
        storage.delete(id);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void notify(String message) {
        System.out.println(name + " get notification: " + message);
    }
}
