public class Reader {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                '}';
    }
}
