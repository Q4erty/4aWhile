package storage;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage<T extends Identifiable> implements Storage<T> {

    public final List<T> items = new ArrayList<>();

    @Override
    public void save(T item) {
        items.add(item);
        System.out.println("Item saved: " + item.toString());
    }

    @Override
    public T findById(int id) {
        for (T item : items) {
            if (item.getId() == id) {  // Теперь getId() точно есть
                return item;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(items);
    }

    @Override
    public void delete(int id) {
        items.removeIf(item -> item.getId() == id);
        System.out.println("Item with ID " + id + " removed.");
    }

    public List<T> getItems() {
        return items;
    }
}
