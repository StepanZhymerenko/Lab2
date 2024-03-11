import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rental implements Serializable {
    private Map<Reader, List<Book>> rentedBooks;

    public Rental() {
        rentedBooks = new HashMap<>();
    }

    public void rentBook(Reader reader, Book book) {
        rentedBooks.computeIfAbsent(reader, k -> new ArrayList<>()).add(book);
    }

    public void returnBook(Reader reader, Book book) {
        if (rentedBooks.containsKey(reader)) {
            rentedBooks.get(reader).remove(book);
        }
    }

    public Map<Reader, List<Book>> getRentedBooks() {
        return rentedBooks;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentedBooks=" + rentedBooks +
                '}';
    }
}
