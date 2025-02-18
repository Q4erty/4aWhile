package item;

import storage.Identifiable;

public abstract class LibraryItem implements Identifiable {

    private int id;

    private String title;

    private boolean available = true;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void getItem() {
        if (available) {
            setAvailable(false);
            System.out.println(title + " borrowed.");
        } else {
            System.out.println(title + " is already taken.");
        }
    }

    public void returnItem() {
        if (!available) {
            setAvailable(true);
            System.out.println(title + " returned.");
        } else {
            System.out.println(title + " wasn't taken.");
        }
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", available=" + available +
                '}';
    }
}
