package item;

import storage.Identifiable;

public class Magazine extends LibraryItem implements Identifiable {

    public Magazine(int id, String title) {
        super(id, title);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
