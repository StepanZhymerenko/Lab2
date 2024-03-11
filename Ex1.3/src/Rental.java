import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rental implements Externalizable {
    private Map<Reader, List<Book>> rentedBooks;

    public Rental() {
        this.rentedBooks = new HashMap<>(); // Ініціалізуємо Map у конструкторі
    }

    public void rentBook(Reader reader, Book book) {
        rentedBooks.computeIfAbsent(reader, k -> new ArrayList<>()).add(book);
    }

    public void returnBook(Reader reader, Book book) {
        if (rentedBooks.containsKey(reader)) {
            rentedBooks.get(reader).remove(book);
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(rentedBooks.size());
        for (Map.Entry<Reader, List<Book>> entry : rentedBooks.entrySet()) {
            out.writeObject(entry.getKey());
            out.writeObject(entry.getValue());
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int size = in.readInt();
        rentedBooks = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            Reader reader = (Reader) in.readObject();
            List<Book> books = (List<Book>) in.readObject();
            rentedBooks.put(reader, books);
        }
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentedBooks=" + rentedBooks +
                '}';
    }
}
