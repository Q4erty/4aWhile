package person;

import item.LibraryItem;

public class Student implements person.User {

    private int id;

    private String name;

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
        item.getItem();
    }

    public void returnBook(LibraryItem item) {
        item.returnItem();
    }

    @Override
    public void notify(String message) {
        System.out.println(name + " get norification: " + message);
    }
}
