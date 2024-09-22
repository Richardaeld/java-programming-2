import java.util.*;

class Lab4 {
    public static void main(String[] args) {
        float inputFloat;
        boolean bKeepRunning = true;
        Scanner  sc       = new Scanner(System.in);
        Checking checking = new Checking();
        Savings  savings  = new Savings();

        while(bKeepRunning) {
            System.out.println("1. Withdraw from Checking");
            System.out.println("2. Withdraw from Savings");
            System.out.println("3. Deposit to Checking");
            System.out.println("4. Deposit to Savings");
            System.out.println("5. Balance of Checking");
            System.out.println("6. Balance of Savings");
            System.out.println("7. Award Interest to Savings now");
            System.out.println("8. Quit");

            int inputInt = sc.nextInt();

            switch (inputInt) {
                case 1:
                    System.out.println("\nHow much would you like to withdraw from Checking?");
                    inputFloat = sc.nextFloat();
                    checking.withdraw(inputFloat);
                    break;

                case 2:
                    System.out.println("\nHow much would you like to withdraw from Savings?");
                    inputFloat = sc.nextFloat();
                    savings.withdraw(inputFloat);
                    break;

                case 3:
                    System.out.println("\nHow much would you like to deposit into Checking?");
                    inputFloat = sc.nextFloat();
                    checking.deposit(inputFloat);
                    break;

                case 4:
                    System.out.println("\nHow much would you like to deposit into Savings?");
                    inputFloat = sc.nextFloat();
                    savings.deposit(inputFloat);
                    break;

                case 5:
                    System.out.println("\nYour balance for checking " + checking.id() + " is " + checking.balance());
                    break;


                case 6:
                    System.out.println("\nYour balance for savings " + savings.id() + " is " + savings.balance());
                    break;

                case 7:
                    savings.interest();
                    break;

                case 8:
                    bKeepRunning = false;
                    System.out.println("\nClosing Program");
                    break;
            }
        }
    }
}

