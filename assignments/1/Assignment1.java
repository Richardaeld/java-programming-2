import java.util.*;

class Assignemnt1 {
    public static void main (String[] args) {
        boolean bKeepRunning = true;
        int inputInt;
        String inputString;
        String returnString;

        Scanner sc = new Scanner(System.in);
        OrderList restaurantOrders = new OrderList();

        System.out.println("1- Create order");
        System.out.println("2- Delete order");
        System.out.println("3- Ready order");
        System.out.println("4- Print order");
        System.out.println("5- Print all orders");
        System.out.println("6- Exit");

        inputInt = sc.nextInt();

        switch (inputInt) {
            // create order
            case 1:
                String[] orderNew = new String[3];

                System.out.println("Enter item 1: ");
                inputString = sc.next();
                orderNew[1] = inputString;

                System.out.println("Enter item 2: ");
                inputString = sc.next();
                orderNew[2] = inputString;

                System.out.println("Enter item 3: ");
                inputString = sc.next();
                orderNew[3] = inputString;

                Order order = new Order(orderNew);

                restaurantOrders.addOrder(order);

                System.out.println("Order has been added.");
                break;

            // delete order
            case 2:
                System.out.println("Please enter order id: ");
                inputInt = sc.nextInt();
                restaurantOrders.RemoveOrder(inputInt);
                System.out.println("Order has been removed.");
                break;

            // ready order
            case 3:
                System.out.println("Please enter order id: ");
                inputInt = sc.nextInt();
                restaurantOrders.readyOrder(inputInt);
                System.out.println("Order has been set to \"Ready\".");
                break;

            // print order
            case 4:
                System.out.println("Please enter order id: ");
                inputInt = sc.nextInt();
                restaurantOrders.printOrder(inputInt);
                break;

            // print all orders
            case 5:
                // restaurantOrders.printOrders();
                break;

            // exit
            case 6: bKeepRunning = false; break;
        }

    }
}

class Order {
    private static int idCounter = 1;
    private int id;
    public boolean ready;
    public String[] lineItems;

    Order() {
        this.id = idCounter++;
        this.ready = false;
        this.lineItems = new String[3];
    }
    Order(String[] order) {
        this.id = idCounter++;
        this.ready = false;
        this.lineItems = order;
    }

    int getId() { return this.id; }

    public String toString() {
        return "Order number: " + this.id + "\n" + (this.ready ? "Ready" : "Not Ready") + "\n" + this.lineItems[0] + "\n" + this.lineItems[1] + "\n" + this.lineItems[2];
    }

}

class OrderList {
    Order[] orderList;

    OrderList () {
        Order[] orderList = new Order[3];
    }
    // orderList = new Order[3];

    void addOrder (Order order) {
        boolean bExtendArray = true;
        for(int i = 0; i < orderList.length; i++) {
            if (orderList[i] == null) {
                orderList[i] = order;
            }
        }
        if (bExtendArray) {
            int arraySizeNew = orderList.length * 2;
            Order[] ordersNew = new Order[arraySizeNew];
            for(int i = 0; i < orderList.length; i++) {
                ordersNew[i] = orderList[i];
            }
            orderList = ordersNew;
        }
    }
    void RemoveOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i].getId() == id) {
                orderList[i] = null;
            }
        }
    }

    void readyOrder(int id) {
        for (int i = 0; i < orderList.length; i++) {
            if (orderList[i].getId() == id) {
                orderList[i].ready = true;
            }
        }
    }

    private void sortOrders() {
        Order[] ordersNew = new Order[orderList.length];
        int intLowest = 0;
        int index = 0;
        for(int x = 0; x < ordersNew.length; x++) {
            intLowest = 0;
            index     = 0;
            for(int y = 0; y < orderList.length; y++) {
                if (intLowest == 0 || intLowest > orderList[y].getId()) {
                    intLowest = orderList[y].getId();
                    index     = y;
                }
            }
            ordersNew[x] = orderList[index];
        }
        orderList = ordersNew;
    }

    String printOrder(int id) {
        for(int i = 0; i < orderList.length; i++) {
            if (orderList[i].getId() == id) {
                return orderList[i].toString();
            }
        }
        return "No such order found";
    }

    void printOrders() {
        // orderList.sortOrders();
        // for(int i = 0; i < orderList.length; i++) {
        //     System.out.println("Ready");
        //     if (orderList[i].ready) {
        //         System.out.println(orderList[i].getId());
        //     }
        // }
        // for(int i = 0; i < orderList.length; i++) {
        //     System.out.println("Preparing");
        //     if (!orderList[i].ready) {
        //         System.out.println(orderList[i].getId());
        //     }
        // }

    }


}