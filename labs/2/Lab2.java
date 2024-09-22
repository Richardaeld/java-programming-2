import java.util.*;

class Lab2 {
    public static void main(String[] args) {
        boolean bKeepRunning = true;
        int inputInt, iter = 0;
        float inputFloat;

        Scanner sc = new Scanner(System.in);

        StockItem Milk  = new StockItem(15, "1 Gallon of Milk", 3.60f);
        StockItem Bread = new StockItem(30, "1 Loaf of Bread" , 1.98f);

        while(bKeepRunning) {
            if (iter++ > 0) System.out.println("");
            System.out.println("1. Sold One Milk");
            System.out.println("2. Sold One Bread");
            System.out.println("3. Change price of Milk");
            System.out.println("4. Change price of Bread");
            System.out.println("5. Add Milk to Inventory");
            System.out.println("6. Add Bread to Inventory");
            System.out.println("7. See Inventory");
            System.out.println("8. Quit");

            inputInt = sc.nextInt();
            System.out.println("");

            switch (inputInt) {
                case 1: Milk.lowerQuantity();  break;
                case 2: Bread.lowerQuantity(); break;

                case 3:
                    System.out.println("What is the new price for Milk");
                    inputFloat = sc.nextFloat();
                    Milk.setPrice(inputFloat);
                    break;

                case 4:
                    System.out.println("What is the new price for Bread");
                    inputFloat = sc.nextFloat();
                    Bread.setPrice(inputFloat);
                    break;

                case 5:
                    System.out.println("How many milk did we get?");
                    inputInt = sc.nextInt();
                    Milk.raiseQuantity(inputInt);
                    break;

                case 6:
                    System.out.println("How many bread did we get?");
                    inputInt = sc.nextInt();
                    Bread.raiseQuantity(inputInt);
                    break;

                case 7:
                    System.out.println("Milk: " + Milk.toString());
                    System.out.println("Bread: " + Bread.toString());
                    break;

                case 8: bKeepRunning = false; break;
            }
        }
    }
}

class StockItem {
    private static int    idCounter = 0;
    private        int    id, quantity;
    private        String description;
    private        float  price;

    StockItem (int quantity, String description, float price) {
        this.id          = idCounter++;
        this.quantity    = quantity;
        this.description = description;
        this.price       = price;
    }
    StockItem () {
        this.id          = idCounter++;
        this.quantity    = 0;
        this.description = "";
        this.price       = 0.00f;
    }

    //  Getters
    public int    id          () { return this.id;         }
    public int    quantity    () { return this.quantity;   }
    public String description () { return this.description;}
    public float  price       () { return this.price;      }

    // Setters
    public void lowerQuantity () {
        if (this.quantity-- < 0) {
            System.out.println("Quantity cannot be below 0!");
            return;
        }
        this.quantity = this.quantity--;
    }

    public void raiseQuantity (int quantity) { this.quantity = this.quantity + quantity; }

    public void setPrice (float price) {
        if (price < 0) {
            System.out.println("Price cannot be below 0!");
            return;
        }
        this.price = price;
    }

    // Overrride toString()
    public String toString () { return "Item number: " + this.id + " is " + this.description + " has price " + this.price + " we currently have " + this.quantity + " in stock"; }

}