package storage;

import java.util.List;

public interface Storage<T> {

    void save(T item);

    T findById(int id);

    List<T> findAll();

    void delete(int id);
}