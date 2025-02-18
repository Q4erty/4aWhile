package storage;

import item.LibraryItem;
import person.User;

import java.io.*;

public class FileStorage implements Backup{

    private static final String FILE_NAME = "data.txt";

    @Override
    public void saveData(InMemoryStorage<LibraryItem> storage, DatabaseStorage users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Library Data Backup\n");

            writer.write("Books:\n");
            for (LibraryItem item : storage.getItems()) {
                writer.write(item.getTitle() + " | Reserved: " + item.isReserved() + "\n");
            }

            writer.write("Users:\n");
            for (User user : users.getDatabase().values()) {
                writer.write(user.toString() + "\n");
            }

            System.out.println("Data successfully saved to file");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Data successfully loaded from file");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
