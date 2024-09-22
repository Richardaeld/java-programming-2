import java.util.*;
public class MailRoom {
    static boolean handleLetter (Letter letter, List<Mail> deliver) {
        if (letter.getDeliveryAddress().equals("") || letter.getReturnAddress().equals(""))                 { return false; }
        if (letter.getLength() < 5        || letter.getLength() > 11.5)                                     { return false; }
        if (letter.getWidth() < 3.5       || letter.getWidth() > 6.125)                                     { return false; }
        if (letter.getThickness() < 0.007 || letter.getThickness() > 0.25)                                  { return false; }
        if (letter.getLength() - letter.getWidth() <= 1.5)                                                  { return false; }
        deliver.add(letter);
        return true;
    }
    static boolean handleFlat(Flat flat, List<Mail> deliver) {
        if (flat.getDeliveryAddress().equals("") || flat.getReturnAddress().equals(""))                     { return false; }
        if (flat.getLength() < 11.5    || flat.getLength() > 15)                                            { return false; }
        if (flat.getWidth() < 6.125    || flat.getWidth() > 12)                                             { return false; }
        if (flat.getThickness() < 0.25 || flat.getThickness() > 0.75)                                       { return false; }
        if (!flat.getContents().equals("DOCUMENTS"))                                                        { return false; }
        deliver.add(flat);
        return true;
    }
    static boolean handleRegularBox(RegularBox regularBox, List<Mail> deliver) {
        if (regularBox.getDeliveryAddress().equals("") || regularBox.getReturnAddress().equals(""))         { return false; }
        if (regularBox.getLength() < 6     || regularBox.getLength() > 27)                                  { return false; }
        if (regularBox.getWidth() < 0.25   || regularBox.getWidth() > 17)                                   { return false; }
        if (regularBox.getHeight() < 3     || regularBox.getHeight() > 17)                                  { return false; }
        if (regularBox.getWeight() < 0     || regularBox.getWeight() > 70)                                  { return false; }
        if (regularBox.getCount() < 0      || regularBox.getCount() > 50)                                   { return false; }
        deliver.add(regularBox);
        return true;
    }
    static boolean handleLiveBox(LiveBox liveBox, List<Mail> deliver) {
        if (liveBox.getDeliveryAddress().equals("") || liveBox.getReturnAddress().equals(""))                { return false; }
        if (liveBox.getLength() < 6    || liveBox.getLength() > 27)                                          { return false; }
        if (liveBox.getWidth() < 0.25  || liveBox.getWidth() > 17)                                           { return false; }
        if (!liveBox.getAnimal().equals("HONEYBEES") && !liveBox.getAnimal().equals("CHICKEN"))              { return false; }
        if (liveBox.getAnimal().equals("HONEYBEES")  && (liveBox.getCount() < 0 || liveBox.getCount() > 20)) { return false; }
        if (liveBox.getAnimal().equals("CHICKEN")    && (liveBox.getCount() < 0 || liveBox.getCount() > 10)) { return false; }
        if (liveBox.getAnimal().equals("CHICKEN")    && (liveBox.getAge() < 0 || liveBox.getAge() > 1))      { return false; }
        deliver.add(liveBox);
        return true;
    }
    static void handled (String packageType, boolean bHandled) {
        String acceptedStatement =  bHandled ? " accepted for delivery." : " cannot be mailed.";
        System.out.println("\n" + packageType + acceptedStatement + "\n");
    }


    public static void main (String[] args) {
        String deliverAddress = "",
            returnAddress = "";
        double width = 0,
            length = 0;
        int userSelection;
        boolean bKeepRunning = true;

        List<Mail> deliver = new ArrayList<Mail>();
        Scanner sc = new Scanner(System.in);

        while (bKeepRunning) {
            System.out.println("1- Send letter");
            System.out.println("2- Send flat");
            System.out.println("3- Send regular box");
            System.out.println("4- Send live box");
            System.out.println("5- Dispatch items");
            System.out.println("6- Quit");
            System.out.println("Enter option:");

            userSelection = sc.nextInt();
// General Package Info
            switch (userSelection) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("\nEnter the delivery address:");
                    sc.nextLine();
                    deliverAddress = sc.nextLine();
                    System.out.println("Enter the return address:");
                    returnAddress = sc.nextLine();
                    System.out.println("Enter the width of your mail:");
                    width = sc.nextDouble();
                    System.out.println("Enter the length of your mail:");
                    length = sc.nextDouble();
            }
// Specific package Info and remaining cases
            switch (userSelection) {
                case 1:
                case 2:
                    System.out.println("Enter the thickness of your mail:");
                    double thickness = sc.nextDouble();
                    System.out.println("Enter the contents of your " + ( userSelection == 1 ? "letter": "Flat") + ":");
                    String contents = sc.next().toUpperCase();
                    switch (userSelection) {
                        case 1:
                            Letter letter = new Letter(deliverAddress, returnAddress, width, length, thickness, contents);
                            handled("Letter", handleLetter(letter, deliver));
                            break;

                        case 2:
                            Flat flat = new Flat(deliverAddress, returnAddress, width, length, thickness, contents);
                            handled("Flat", handleFlat(flat, deliver));
                            break;
                    }
                    break;

                case 3:
                case 4:
                    System.out.println("Enter the height of your mail:");
                    double height = sc.nextDouble();
                    System.out.println("Enter how many items your box has:");
                    int count = sc.nextInt();
                    switch (userSelection) {
                        case 3:
                            System.out.println("Enter the weight of your box:");
                            double weight = sc.nextDouble();
                            System.out.println("Enter the contents of your box:");
                            String items = sc.next();
                            RegularBox regularBox = new RegularBox(deliverAddress, returnAddress, width, length, height, count, items, weight);
                            handled("Regular box", handleRegularBox(regularBox, deliver));
                            break;

                        case 4:
                            System.out.println("Enter what animal is being shipped:");
                            String animal = sc.next().toUpperCase();
                            System.out.println("Enter age of the oldest animal, in days:");
                            int age = sc.nextInt();
                            LiveBox liveBox = new LiveBox(deliverAddress, returnAddress, width, length, height, count, animal, age);
                            handled("Live Box", handleLiveBox(liveBox, deliver));
                            break;
                    }
                    break;

                case 5:
                    String deliveringText = deliver.size() > 0 ? "DISPATCHING THE FOLLOWING ITEMS FOR DELIVERY:\n==========" : "Delivery queue is empty.\n";
                    System.out.println(deliveringText);
                    for(Mail dispatch: deliver) {
                        System.out.println(dispatch.toString());
                        System.out.println("==========");
                    }
                    deliver.clear();
                    break;

                case 6:
                    bKeepRunning = false;
                    System.out.println("Quitting...");
                    break;
            }
        }
    }
}
