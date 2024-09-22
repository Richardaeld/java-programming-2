import java.util.*;

class Driver {
    public static void main (String[] args) {
        boolean bKeepRunning = true;
        int input, formula, iteration;

        Scanner sc = new Scanner(System.in);

        FibFormula   fibFormula   = new FibFormula();
        FibIteration fibIteration = new FibIteration();


        while (bKeepRunning) {
            System.out.println("Enter the number you want to find the Fibonacci Series for:");
            input     = sc.nextInt();
            formula   = fibFormula.calculateFib(input);
            iteration = fibIteration.calculateFib(input);

            System.out.println("Fib of " + input + " by iteration is : " + iteration);
            System.out.println("Fib of " + input + " by formula is : "   + formula);
        }
    }
}
