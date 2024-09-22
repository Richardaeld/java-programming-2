import java.util.*;

class Assignment2 {
    public static void main (String[] args) {
        boolean bKeepRunning   = true;
        boolean bKeepSearching = true;
        int inputInt;
        String inputString;
        Bus bus       = null;
        Person person = null;

        Scanner sc = new Scanner(System.in);
        Dispatcher dispatcher = new Dispatcher();

        while (bKeepRunning) {
            System.out.println("");
            System.out.println("Bus Dispatching System");
            System.out.println("1. Add bus");
            System.out.println("2. Add Person to bus");
            System.out.println("3. Remove bus");
            System.out.println("4. Remove person");
            System.out.println("5. List passengers");
            System.out.println("6. List busses");
            System.out.println("7. Requeue bus");
            System.out.println("8. Transfer person");
            System.out.println("9. Dispatch bus");
            System.out.println("0. Exit");

            inputInt = sc.nextInt();

            switch(inputInt) {
                case 1:  //Add bus
                    bus = new Bus();
                    int position = dispatcher.addBus(bus);
                    System.out.println("\nBus " + bus.busId() + " added to position " + position);
                    break;

                case 2:  //Add Person to bus
                    bKeepSearching = true;
                    System.out.println("\nEnter bus id: ");
                    inputInt = sc.nextInt();
                    bus = dispatcher.findBus(inputInt);
                    if (bus == null) {
                        System.out.println("No bus with id " + inputInt);
                        continue;
                    }

                    System.out.println("Enter person's name: ");
                    inputString = sc.next();
                    person = new Person(inputString);

                    bus.addPerson(person);
                    System.out.println(inputString + " has been added to bus " + bus.busId());
                    break;

                case 3:  // Remove bus
                    System.out.println("\nEnter bus id: ");
                    inputInt = sc.nextInt();
                    bus = dispatcher.findBus(inputInt);
                    if (bus == null) {
                        System.out.println("No bus with id " + inputInt);
                        break;
                    }
                    dispatcher.removeBus(inputInt);
                    System.out.println("Bus " + bus.busId() + " removed");
                    break;

                case 4:  //Remove person
                    System.out.println("\nEnter bus id: ");
                    inputInt = sc.nextInt();
                    bus = dispatcher.findBus(inputInt);
                    if (bus == null) {
                        System.out.println("No bus with id " + inputInt);
                    } else {
                        System.out.println("Enter person's name: ");
                        inputString = sc.next();
                        person = bus.findPerson(inputString);
                        if (person == null) {
                            System.out.println("No such person found in bus " + bus.busId());
                        } else {
                            bus.removePerson(person);
                            System.out.println(inputString + " has been removed from bus " + bus.busId());
                        }
                    }
                    break;

                case 5:  // list passengers
                    System.out.println("\nEnter bus id: ");
                    inputInt = sc.nextInt();
                    bus = dispatcher.findBus(inputInt);
                    if (bus == null) {
                        System.out.println("No bus with id " + inputInt);
                    } else {
                        System.out.println("Bus " + bus.busId());
                        System.out.println(bus.getPassengers());
                    }
                    break;

                case 6:  // List busses
                        System.out.println("\nBUS QUEUE");
                        System.out.println(dispatcher.toString());
                    break;

                case 7:  // Requeue bus
                    System.out.println("\nEnter bus id: ");
                    inputInt = sc.nextInt();
                    bus = dispatcher.findBus(inputInt);
                    if (bus == null) {
                        System.out.println("No bus with id " + inputInt);
                    } else {
                        System.out.println("Enter new bus position:");
                        inputInt = sc.nextInt();
                        dispatcher.removeBus(inputInt);
                        int busPosition = dispatcher.addBus(bus, inputInt);
                        System.out.println("Bus " + bus.busId() + " added to position " + busPosition);
                    }
                    break;

                case 8:  // Transfer person
                    System.out.println("\nEnter person's name: ");
                    inputString = sc.next();
                    System.out.println("Enter bus id of bus 1: ");
                    int searchBus1 = sc.nextInt();
                    System.out.println("Enter bus id of bus 2: ");
                    int searchBus2 = sc.nextInt();

                    Bus bus1 = dispatcher.findBus(searchBus1);
                    Bus bus2 = dispatcher.findBus(searchBus2);

                    if (bus1 == null) {
                        if (bus1 == null) System.out.println("No bus with id " + searchBus1);
                        break;
                    }

                    if (bus2 == null) {
                        if (bus2 == null) System.out.println("No bus with id " + searchBus2);
                        break;
                    }

                    person = bus1.findPerson(inputString);
                    if (person == null) {
                        System.out.println("No person named " + inputString);
                        break;
                    }

                    if(bus1.transferPerson(bus1, bus2, person)) {
                        System.out.println("Person transferred successfully.");
                    } else {
                        System.out.println("Person transfer failed.");
                    }

                    break;

                case 9:  // Dispatch bus
                    bus = dispatcher.dispatchBus();
                    if (bus == null) {
                        System.out.println("\nBus queue is empty");
                    } else {
                        System.out.println("\nBus " + bus.busId() + " has been dispatched");
                    }
                    break;

                case 0:
                    bKeepRunning = false;
                    System.out.println("\nShutting Down.");
                    break;

            }
        }
        sc.close();
    }
}

class Person {
    private String name;
    private int ticketNumber;
    private static int nextTicketNumber = 0;

    Person() {
        this.name         = "NO NAME";
        this.ticketNumber = nextTicketNumber++;
    }
    Person(String name) {
        this.name = name;
        this.ticketNumber = nextTicketNumber++;
    }
    public String toString() {
        return ticketNumber + "\t" + name + "\n";
    }
}

class Bus {
    private static int nextId;
    private int busId;
    ArrayList<Person> passengers;

    // constructor
    Bus () {
        this.passengers = new ArrayList<Person>();
        this.busId = nextId++;
    }

    // getters / setters
    int busId() {return busId;}

    // methods
    void addPerson(Person person){
        passengers.add(person);
    }

    boolean removePerson(Person person){
        boolean bRemoved = false;
        
        for(Person removePerson: passengers) {
            if (removePerson == person) {
                passengers.remove(removePerson);
                bRemoved = true;
            }
        }
        return bRemoved;
    }

    Person findPerson(String name){
        for (Person findPerson: passengers) {
            if (findPerson.toString().contains(name)) {
                return findPerson;
            }
        }
        return null;
    }

    static boolean transferPerson(Bus bus1, Bus bus2, Person person) {
        if (bus1.passengers.size() > 1) {
            for(Person transfer: bus1.passengers) {
                if (transfer == person) {
                    bus1.passengers.remove(transfer);
                    bus2.passengers.add(transfer);
                    return true;
                }
            }
        } else {
            bus1.passengers.remove(person);
            bus2.passengers.add(person);
            return true;
        }
        return false;
    }

    String getPassengers() {
        String sPassengers = "";
        for(Person getPassengars : passengers) {
            sPassengers += getPassengars.toString();
        }
        return sPassengers;
    }

    public String toString() {
        return busId+"" ;
    }
}

class Dispatcher {
    ArrayList<Bus> busQueue = new ArrayList<Bus>();

    int addBus(Bus bus) {
        busQueue.add(bus);
        int i = 0;
        for (i = 0; i < busQueue.size(); i++) {
            if (busQueue.get(i) == bus){
                return i;
            }
        }
        return i;
    }


    int addBus(Bus bus, int position) {
        int i = 0;
        if (position <= busQueue.size() && busQueue.get(i) == null) {
            busQueue.add(bus);
            return busQueue.size() + 1;
        } else {
            for (i = 0; i < busQueue.size(); i++) {
                if (busQueue.get(i) == null) {
                    busQueue.add(bus);
                    return i;
                }
            }
        }
        return i;
    }

    Bus findBus(int id) {
        Bus foundBus = null;
        for(Bus searchBus: busQueue) {
            if (searchBus.busId() == id) {
                return searchBus;
            }
        }
        return foundBus;
    }

    Bus removeBus(int id) {
        Bus removedBus = null;
        for (Bus removeBus: busQueue) {
            if (removeBus.busId() == id) {
                busQueue.remove(removeBus);
                return removeBus;
            }
        }
        return removedBus;
    }
    Bus dispatchBus() {
        for (Bus dispatchBus: busQueue) {
            if (dispatchBus != null) {
                busQueue.remove(dispatchBus);
                return dispatchBus;
            }
        }
        return null;
    }

    public String toString() {
        String sReturn = "";
        for (Bus busInfo: busQueue) {
            sReturn += busInfo.busId()+"\n";
        }
        return sReturn;
    }
}