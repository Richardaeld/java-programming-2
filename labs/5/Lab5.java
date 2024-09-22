import java.util.*;

class Lab5 {
    public static void main (String[] args) {
        char inputChar;
        int inputInt, iter = 0;
        String name, author;

        Scanner sc = new Scanner(System.in);

        Item[] items = new Item[5];

        while (iter < 5) {
            name = "";
            author = "";
            System.out.println("Please enter B for Book or P for Periodical");
            inputChar = sc.next().charAt(0);
            switch (inputChar) {
                case 'B':
                    System.out.println("Please enter the name of the Book");
                    name += sc.nextLine();
                    name += sc.nextLine();
                    System.out.println("Please enter the author of the Book");
                    author += sc.nextLine();
                    System.out.println("Please enter the ISBN of the Book");
                    inputInt = sc.nextInt();
                    items[iter] = new Book(name, inputInt, author);
                    iter++;
                    break;

                case 'P':
                    System.out.println("Please enter the name of Periodical");
                    name += sc.nextLine();
                    name += sc.nextLine();
                    System.out.println("Please enter the issue number");
                    inputInt = sc.nextInt();
                    items[iter] = new Periodical(name, inputInt);
                    iter++;
                    break;

            }
        }
        for (Item item : items) {
            System.out.println(item.getListing());
        }
    }
}