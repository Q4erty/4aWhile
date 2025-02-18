package storage;

import item.LibraryItem;

public interface Backup {

    void saveData(InMemoryStorage<LibraryItem> storage, DatabaseStorage users);

    void loadData();
}
