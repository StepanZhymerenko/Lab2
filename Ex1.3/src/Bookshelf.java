import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bookshelf implements Externalizable {
    private List<Book> books;

    public Bookshelf() {
        this.books = new ArrayList<>(); // Ініціалізуємо список у конструкторі
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(books.size());
        for (Book book : books) {
            out.writeObject(book);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int size = in.readInt();
        books = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            books.add((Book) in.readObject());
        }
    }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "books=" + books +
                '}';
    }
}
