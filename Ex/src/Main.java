import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create objects
        Author author1 = new Author("John Doe", "USA");
        Author author2 = new Author("Jane Smith", "UK");

        Book book1 = new Book("Java Programming", author1);
        Book book2 = new Book("Introduction to Algorithms", author2);

        Reader reader1 = new Reader("Alice");
        Reader reader2 = new Reader("Bob");

        // Create library components
        Bookshelf bookshelf = new Bookshelf();
        Rental rental = new Rental();

        // Populate library
        bookshelf.addBook(book1);
        bookshelf.addBook(book2);

        rental.rentBook(reader1, book1);
        rental.rentBook(reader2, book2);

        // Display current state
        System.out.println("Initial state:");
        System.out.println(bookshelf);
        System.out.println(rental);

        // Serialize
        serializeLibrary(bookshelf, "library.ser");

        // Deserialize
        Bookshelf deserializedBookshelf = deserializeLibrary("library.ser");

        // Display deserialized state
        System.out.println("\nDeserialized state:");
        System.out.println(deserializedBookshelf);
    }

    private static void serializeLibrary(Object object, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(object);
            System.out.println("Serialized object saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Bookshelf deserializeLibrary(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Object object = inputStream.readObject();
            if (object instanceof Bookshelf) {
                return (Bookshelf) object;
            } else {
                throw new IllegalArgumentException("Invalid object type");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
