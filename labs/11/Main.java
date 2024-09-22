import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean bKeepRunning = true;
        int choice, year;
        String title, director;
        double cost;

        Scanner sc = new Scanner(System.in);
        BlueRayCollection collection = new BlueRayCollection();

//        collection.add("Jaws", "Steven Spielberg", 1975, 19.95);
//        collection.add("Jurassic Park", "Steven Spielberg", 1993, 17.99);

        while (bKeepRunning) {

            System.out.println("0. Quit");
            System.out.println("1. Add BlueRay to collection");
            System.out.println("2. See collection");
            choice = sc.nextInt();

            switch(choice) {
                case 0: bKeepRunning = false; break;

                case 1:
                    try {
                        System.out.println("What is the title?");
                        title = "";
                        title += sc.nextLine();
                        title += sc.nextLine();
                        System.out.println("What is the director?");
                        director = sc.nextLine();
                        System.out.println("What is the year of release?");
                        year = sc.nextInt();
                        System.out.println("What is the cost?");
                        cost = sc.nextDouble();
                        collection.add(title, director, year, cost);
                    } catch (Exception e) {
                        System.out.println("Incorrect information, try again");
                    }
                    break;

                case 2: collection.show_all(); break;


            }

        }

    }
}