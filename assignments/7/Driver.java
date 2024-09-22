import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jasmine, earl, lemon, totalEmployees, totalBoxes = 0;
        List<Thread>   threads   = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        jasmine = 2000;
        earl = 1000;
        lemon = 3000;
        totalEmployees = 5;

        System.out.println("[The GatlingTea Factory]");
        System.out.println("How many boxes of Jasmine Tea would you like to order?");
//        jasmine = sc.nextInt();
        System.out.println("How many boxes of Earl Grey Tea would you like to order?");
//        earl = sc.nextInt();
        System.out.println("How many boxes of Lemon Tea would you like to order?");
//        lemon = sc.nextInt();
        System.out.println("The Drum™ has been created and shipped.");
        System.out.println("How many employees will help unload?");
//        totalEmployees = sc.nextInt();

        TheDrum drum      = new TheDrum(jasmine, earl, lemon);
        try {
            for(int i = 0; i < totalEmployees; i++) {
                Employee employee = new Employee(drum);
                employees.add(employee);
                Thread thread     = new Thread(employee);
                threads.add(thread);
            }
            for(Thread thread: threads) {
                thread.start();
            }
            for(Thread thread: threads) {
                thread.join();
            }

            for(Employee emp: employees) {
                System.out.println(emp.toString());
                totalBoxes += emp.totalTea();
            }
        } catch (Exception e) {
            System.out.println(e);
            e.getStackTrace();
        }
        System.out.println("A total of " + totalBoxes + " boxes of tea were stocked.");
    }
}