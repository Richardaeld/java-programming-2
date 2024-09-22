import java.util.*;

public class Lab7B {
    static String  repeatNTimes (String str, int repeat) {
        if (repeat == 1) return str;
        return str + repeatNTimes(str, repeat-1);
    }

    static boolean isReverse (String str, String reverse) {
        if (str.length() == 0 || reverse.length() == 0) return true;
//        System.out.println(str.substring(0, 1) + " == " + reverse.substring(reverse.length()-1));
        if (!str.substring(0, 1).equals(reverse.substring(reverse.length()-1))) return false;

        str = str.substring(1);
        reverse = reverse.substring(0, reverse.length()-1);

        return  isReverse (str, reverse);
    }

    public static void main(String[] args) {
        String input1, input2;
        Scanner sc = new Scanner(System.in);

        System.out.println(repeatNTimes("I must study recursion until it makes sense\n", 100));

        System.out.println("Enter the first string");
        input1 = sc.nextLine();
        System.out.println("Enter the second string");
        input2 = sc.nextLine();
        if(isReverse(input1, input2)) {
            System.out.println(input1 + " is the reverse of " + input2);
        } else {
            System.out.println(input1 + " is not the reverse of " + input2);
        }
    }
}