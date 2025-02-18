package storage;

import person.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DatabaseStorage implements Storage<User> {

    private final Map<Integer, User> database = new HashMap<>();

    @Override
    public void save(User user) {
        database.put(user.getId(), user);
        System.out.println("Saved to database: [" + user.getId() + "] -> " + user.getName());
    }

    @Override
    public User findById(int id) {
        User user = database.get(id);
        if (user != null) {
            System.out.println("Loaded from database: [" + id + "] -> " + user.getName());
        } else {
            System.out.println("Data with ID " + id + " not found.");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void delete(int id) {
        if (database.remove(id) != null) {
            System.out.println("Deleted from database: " + id);
        } else {
            System.out.println("ID " + id + " not found in database.");
        }
    }

    public Map<Integer, User> getDatabase() {
        return database;
    }
}
