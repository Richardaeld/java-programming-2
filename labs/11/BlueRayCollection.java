public class BlueRayCollection {
    private Node head = new Node(); // Node on creation inits to null

//    public void addHead(String title, String director, int year, double cost) {
//        BlueRayDisk disk = new BlueRayDisk(title, director, year,cost);
//        Node node = new Node();
//        node.disk = disk;
//        node.next = head;
//    }

    public void add(String title, String director, int year, double cost) { //addBack
        BlueRayDisk disk = new BlueRayDisk(title, director, year,cost);
        Node temp = new Node();
        temp.disk = disk;

        if (head.disk == null) { head = temp; return; }
        Node nodeCurrent = head;
        while (nodeCurrent.next != null) {
            nodeCurrent = nodeCurrent.next;
        }
        nodeCurrent.next = temp;
    }

    public void show_all () {
        String displayCollection = "";
        Node nodeCurrent = head;
        while (nodeCurrent.next != null) {
            displayCollection += " " + nodeCurrent.disk + " \n";
            nodeCurrent = nodeCurrent.next;
        }
        displayCollection += " " + nodeCurrent.disk;
        System.out.println(displayCollection);

    }
}
