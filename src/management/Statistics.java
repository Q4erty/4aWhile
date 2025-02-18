package management;

import item.Book;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    private final Map<String, Integer> bookPopularity = new HashMap<>();

    public void recordBorrow(Book book) {
        bookPopularity.put(book.getTitle(), bookPopularity.getOrDefault(book.getTitle(), 0) + 1);
    }

    public void printStatistics() {
        bookPopularity.forEach((book, count) -> System.out.println(book + " borrowed " + count + " times"));
    }
}
