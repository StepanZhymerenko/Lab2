import java.io.*;

public class Reader implements Externalizable {
    private String name;

    public Reader() {} // Пустий конструктор

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }

    // Getter, toString та інші методи, які вам можуть знадобитися
}
