package management;

import item.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class UserHistory {

    private final List<String> transactions = new ArrayList<>();

    public void addEntry(LibraryItem item, String action) {
        transactions.add(action + " " + item.getTitle());
    }

    public List<String> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "transactions=" + transactions +
                '}';
    }
}