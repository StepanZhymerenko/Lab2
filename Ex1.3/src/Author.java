import java.io.*;

public class Author implements Externalizable {
    private String name;
    private String nationality;

    public Author() {} // Пустий конструктор

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(nationality);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        nationality = (String) in.readObject();
    }

    // Getter, toString та інші методи, які вам можуть знадобитися
}
