import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class InvalidTimeException extends Exception {
    InvalidTimeException (String str) {
        super (str);
    }
}

public class Main {
    static boolean Sterilize (String aTime[]) throws Exception {
        if (aTime.length < 3) throw new Exception ("Enter a valid time");
        for (int i = 0; i < aTime.length; i++) {
            if (Pattern.compile("\\D").matcher(aTime[i]).find())   throw new Exception ("Invalid Characters");
            switch (i) {
                case 0: if (Integer.parseInt(aTime[i]) > 23) throw new Exception("Hour must be below 24");  break;
                case 1: if (Integer.parseInt(aTime[i]) > 59) throw new Exception("Minutes must be less than 60"); break;
                case 2: if (Integer.parseInt(aTime[i]) > 59) throw new Exception("Seconds must be less than 60"); break;
            }
        }
        return true;
    }

    static String[] userInput (int count) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter time " + (count + 1) + " in 24hr format as follows (HH:MM:SS)");
        String sInput = sc.nextLine();

        return sInput.split(":", 3);
    }

    public static void main(String[] args) {
        int[] aTotal       = {0, 0};
        String[][] a2Input = new String[2][4];
        boolean bSterile;
        try {
                try {
                    bSterile = true;
                    for(int x = 0; x < 2; x++) {
                        a2Input[x] = userInput (x);
                        bSterile = Sterilize (a2Input[x]);
                        aTotal[x] += Integer.parseInt(a2Input[x][2]);
                        aTotal[x] += 60 *  Integer.parseInt(a2Input[x][1]);
                        aTotal[x] += 60 * 60 * Integer.parseInt(a2Input[x][0]);
                    }
                } catch (Throwable e) {
                    bSterile = false;
                    System.out.println(e.getMessage());
                }
                if (!bSterile) throw new Exception ("");

            System.out.println("Difference in seconds: " + Math.abs(aTotal[0] - aTotal[1]));
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}
