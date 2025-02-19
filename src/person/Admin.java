package person;

import item.LibraryItem;
import storage.Storage;

public class Admin implements User {

    private int id;

    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public void addUser(Storage<User> storage, User user) {
        storage.save(user);
    }

    public void deleteUser(Storage<User> storage, int id) {
        storage.delete(id);
    }

    public void watchUsers(Storage<LibraryItem> storage) {
        storage.findAll().forEach(System.out::println);
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

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
