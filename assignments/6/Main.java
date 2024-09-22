import java.util.*;
import java.io.*;


public class Main {
    static void processComplaint(Complaint complaint) throws StateComplaintException{
        switch (complaint.causeOfActionGet()){
            case "Equal Protection Challenge":
            case "Title IX Workplace Discrimination":
            case "Prisoner Civil Rights Claim":
            case "Fair Labor Standard Act Claim": return;
        }
        if (complaint.plaintiffCitizenshipGet().equals(complaint.defendantCitizenshipGet()))    throw new StateComplaintException ("Lack of Diversity");
        if (complaint.amountInControversyGet() <= 75000)                                        throw new StateComplaintException ("Amount in controversy less than or equal to $75000");
        if (complaint.defendantCitizenshipGet().equals(complaint.originalStateOfFillingsGet())) throw new StateComplaintException("No prejudice through diversity");
    }

    public static void main(String[] args) {
        Scanner     sc         = new Scanner(System.in);
        Complaint   complaint  = null;
        PrintWriter pwAccepted = null;
        PrintWriter pwRemanded = null;

        int countAccepted = 0,
            countRemanded = 0;
        String name, data;
        String[] dataArr;
        try {
            pwAccepted = new PrintWriter("accepted.txt");
            pwRemanded = new PrintWriter("remanded.txt");
            System.out.println("[Federal Court Complaint Processor]");
            System.out.println("Enter file name to process:");
            name = sc.nextLine();
//            name = "a.txt";

            File file = new File(name);
            if (!file.exists()) throw new Exception("No file with name " + name);
            Scanner scFile = new Scanner(file);

            while (scFile.hasNextLine()) {
                dataArr = scFile.nextLine().split(",");
                complaint = new Complaint(dataArr[0], Double.parseDouble(dataArr[1]), dataArr[2], dataArr[3], dataArr[4]);
                data =  "Case ID: "                 + complaint.idGet()                      + "\n" +
                        "Cause of action: "         + complaint.causeOfActionGet()           + "\n" +
                        "Amount in Controversy: $"  + complaint.amountInControversyGet()     + "\n" +
                        "Plaintiff’s Citizenship: " + complaint.plaintiffCitizenshipGet()    + "\n" +
                        "Defendant’s Citizenship: " + complaint.defendantCitizenshipGet()    + "\n" +
                        "Originally filed in: "     + complaint.originalStateOfFillingsGet() + "\n";

                try {
                    processComplaint(complaint);
                    pwAccepted.println(data + "==============================");
                    countAccepted++;
                } catch (StateComplaintException e) {
                    pwRemanded.println(data + "\nReason for remand: " + e.getMessage() + "\n" + "==============================");
                    countRemanded++;
                }
            }
            System.out.println("Processing complete. Accepted cases written to accepted.txt and remanded cases written to remanded.txt");
            System.out.println("Number of remanded cases: " + countRemanded);
            System.out.println("Number of accepted cases: " + countAccepted);
            scFile.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Shutting down...");
            pwAccepted.close();
            pwRemanded.close();

        }
    }
}