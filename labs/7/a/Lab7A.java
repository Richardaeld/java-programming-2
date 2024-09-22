import java.util.*;

class Lab7A {
    static int recursive_multiply (int x, int y) {
        if (y == 0) return 0;
        return  x + recursive_multiply(x , y-1);
    }

    static int recursive_div (int x, int y) {
        if (y == 0) return -1;
        if (x == y) return 1;
        if (y > x ) return 0;

        return 1 + recursive_div(x-y ,y);
    }

    static int recursive_mod (int x, int y) {
        if (y == 0) return -1;
        if (y > x ) return x;

        return recursive_mod(x-y ,y);
    }

    public static void main(String[] args) {
        boolean bKeepRunning = true;
        int choice, input1, input2, result = 0;

        Scanner sc = new Scanner(System.in);

        while (bKeepRunning) {
            System.out.println("Choose from the following:");
            System.out.println("0. Quit");
            System.out.println("1. Multiply 2 numbers");
            System.out.println("2. Div 2 numbers");
            System.out.println("3. Mod 2 numbers");

            choice = sc.nextInt();
            System.out.println("Enter first number");
            input1 = sc.nextInt();
            System.out.println("Enter second number");
            input2 = sc.nextInt();

            switch (choice) {
                case 0: bKeepRunning = false; break;
                case 1: result = recursive_multiply(input1, input2); break; // *
                case 2: result = recursive_div(input1, input2); break;  // /
                case 3: result = recursive_mod(input1, input2); break;  // %
            }
            System.out.println("Answer: " + result);
        }
    }
}
