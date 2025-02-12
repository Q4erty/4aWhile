package storage;

import item.LibraryItem;

import java.util.ArrayList;
import java.util.List;

class InMemoryStorage implements Storage<LibraryItem> {
    private final List<LibraryItem> items = new ArrayList<>();

    @Override
    public void save(LibraryItem item) {
        items.add(item);
        System.out.println("Item saved: [" + item.getId() + "] -> " + item.getTitle());
    }

    @Override
    public LibraryItem findById(int id) {
        for (LibraryItem item : items) {
            if (item.getId() == id) {
                System.out.println("Item found: [" + id + "] -> " + item.getTitle());
                return item;
            }
        }
        System.out.println("Item with ID " + id + " not found.");
        return null;
    }

    @Override
    public List<LibraryItem> findAll() {
        System.out.println("Retrieving all items from memory storage.");
        return new ArrayList<>(items);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                System.out.println("Item deleted: [" + id + "] -> " + items.get(i).getTitle());
                items.remove(i);
                return;
            }
        }
        System.out.println("Item with ID " + id + " not found in memory storage.");
    }
}
