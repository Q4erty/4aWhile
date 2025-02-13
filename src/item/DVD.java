package item;

import storage.Identifiable;

public class DVD extends LibraryItem implements Identifiable {

    public DVD(int id, String title) {
        super(id, title);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
