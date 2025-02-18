package item;

import storage.Identifiable;

public abstract class LibraryItem implements Identifiable {

    private int id;

    private String title;

    private boolean reserved = true;

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

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void getItem() {
        if (reserved) {
            setReserved(false);
            System.out.println(title + " borrowed.");
        } else {
            System.out.println(title + " is already taken.");
        }
    }

    public void returnItem() {
        if (!reserved) {
            setReserved(true);
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
                ", available=" + reserved +
                '}';
    }
}
