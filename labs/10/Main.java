import java.util.*;

class Baby implements Runnable {
    String name;
    int time;
    Baby (String name) {
        this.name = name;
        Random rand = new Random();
        time = rand.nextInt(5000);
    }
    public void run() {
        try {
            System.out.println("My name is " + name + " I am going to sleep for " + time + "ms");
            Thread.sleep(time);
            System.out.println("My name is " + name + ", I am awake, feed me!!!");
        } catch (InterruptedException e) {
            System.out.println(e.getStackTrace());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] names = {"Noah", "Olivia", "Liam", "Emma", "Amelia"};

        for (String name: names) {
            Thread thread = new Thread(new Baby(name));
            thread.start();
        }

//        Thread b1 = new Thread(new Baby("Noah"));
//        Thread b2 = new Thread(new Baby("Olivia"));
//        Thread b3 = new Thread(new Baby("Liam"));
//        Thread b4 = new Thread(new Baby("Emma"));
//        Thread b5 = new Thread(new Baby("Amelia"));

//        b1.start();
//        b2.start();
//        b3.start();
//        b4.start();
//        b5.start();
    }
}