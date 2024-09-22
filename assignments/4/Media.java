abstract public class Media {
    private int id;
    private static int nextId = 1;
    private String fileName;

    Media () {
        id = nextId;
        nextId++;
    }
    Media (String fileName) {
        id = nextId;
        nextId++;
        this.fileName = fileName;
    }

    int getId          () { return id; }
    String getFileName () { return fileName; }


}

