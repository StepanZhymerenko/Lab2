import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bookshelf implements Serializable {
    private List<Book> books;

    public Bookshelf() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "books=" + books +
                '}';
    }
}
