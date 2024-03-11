import java.io.*;

public class Book implements Externalizable {
    private String title;
    private Author author;

    public Book() {} // Пустий конструктор

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeObject(author);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        author = (Author) in.readObject();
    }

    // Getter, toString та інші методи, які вам можуть знадобитися
}
