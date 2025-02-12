package storage;

import java.util.List;

// Интерфейс для хранения данных
public interface Storage<T> {

    void save(T item);

    T findById(int id);

    List<T> findAll();

    void delete(int id);
}