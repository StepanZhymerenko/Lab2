import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private transient Author author; // transient - не буде серіалізований

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
