    
import java.util.*;

class test {
    public static void main(String[] args) {
        ArrayList<Bus> list = new ArrayList<Bus>();


        Bus bus = new Bus();


        list.add(bus);
        list.add(bus);
        list.add(bus);
        list.add(bus);
        list.add(bus);
        list.add(bus);

        list.remove(3);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        // System.out.println(list.get(6));


    }
}

class Bus {
    private static int nextId;
    private int busId;

    // constructor
    Bus () {
        this.busId = nextId++;
    }


}