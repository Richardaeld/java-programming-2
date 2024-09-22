import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String data1, data2;
        int counter = 0;
        try {
            File file1 = new File("remanded.txt"),
                 file2 = new File("remanded1.txt");
            if (!file1.exists() || !file2.exists()) throw new Exception ("Both files do not exist!");
            Scanner sc1 = new Scanner(file1),
                    sc2 = new Scanner (file2);
            while(sc1.hasNextLine() && sc2.hasNextLine()) {
                counter++;
                data1 = sc1.nextLine();
                data2 = sc2.nextLine();
                if (!data1.equals(data2)) System.out.println("Line " + counter + "\n" + "< " + data1 + "\n" + "> " + data2);
            }
            if (sc1.hasNextLine() || sc2.hasNextLine()) throw new Exception("Files have different number of lines");
        } catch (Throwable e) { System.out.println(e.getMessage()); }
    }
}