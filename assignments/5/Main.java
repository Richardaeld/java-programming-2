import java.util.*;

public class Main {

    static void testCase() {
        String seq1 = "TGTTGTTCTTTTTGAACCTTATTGATGTTT",
                seq2 = "TGTTATTATTTTGAACCTTATTGATGTTT",
                seq3 = "TGTTATTATTTTUGAACCTTATTAATGTTT";

        String seq1Rev   = "TTTGTAGTTATTCCAAGTTTTTCTTGTTGT";
        String seq1inv   = "AAACATCAATAAGGTTCAAAAAGAACAACA";
        String seq1Trans = "KHQ-GSKRTT";
        DNALib lab = new DNALib();

        System.out.println("Valid DNA: " + lab.validator(seq1));
//        System.out.println(lab.validator(seq2));
//        System.out.println(lab.validator(seq3));

        seq1 = lab.reverser(seq1);
        System.out.println(seq1);
        System.out.println(seq1Rev);
        System.out.println("Sucessfully reversed: " + seq1.equals(seq1Rev));

        seq1 = lab.inverser(seq1);
        System.out.println(seq1);
        System.out.println(seq1inv);
        System.out.println("Successfully inversed: " + seq1.equals(seq1inv));

        seq1 = lab.translator(seq1);
        System.out.println(seq1);
        System.out.println(seq1Trans);
        System.out.println("Successfully translated: " + seq1.equals(seq1Trans));

    }

    public static void main(String[] args) {
        DNALib lab = new DNALib();
        Scanner sc = new Scanner(System.in);
        String input = "";

        System.out.println("[DNA Reverser and Translator]");
        System.out.println("Enter a sequence:");

        input += sc.next();
        input = input.toUpperCase();
        System.out.println(input);
        if (!lab.validator(input)) {
            System.out.println("Your DNA sequence is not valid.");
            return;
        }

        input = lab.reverser(input);
        input = lab.inverser(input);
        input = lab.translator(input);
        System.out.println("Your DNA sequence reversed and translated is: " + input);



//        testCase();
    }
}