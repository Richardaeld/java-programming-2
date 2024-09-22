public class Employee implements Runnable {
    private TheDrum pallet;
    private int totalJasmine;
    private int totalEarlGrey;
    private int totalLemon;
    private int id;
    private static int nextId = 0;

    Employee (TheDrum pallet) {
        this.pallet        = pallet;
        this.totalJasmine  = 0;
        this.totalEarlGrey = 0;
        this.totalLemon    = 0;
        this.id            = nextId++;
    }

    int totalTea() {
        return totalJasmine + totalEarlGrey + totalLemon;
    }

    public void run() {
        try {
            TeaBox nextTeaBox;
            nextTeaBox = pallet.nextTeaBoxGet();
//            int counter = 0;
            while (nextTeaBox != null) {
//                counter++;
                switch (nextTeaBox.teaTypeGet()) {
                    case "jasmine" : totalJasmine++;  break;
                    case "earlGrey": totalEarlGrey++; break;
                    case "lemon"   : totalLemon++;    break;
                }
                nextTeaBox = pallet.nextTeaBoxGet();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println("");
//            do nothing
        }
    }

    public String toString () {
        return "Employee " + id + " has unloaded " +
                totalJasmine  + " boxes of Jasmine Tea, " +
                totalEarlGrey + " boxes of Earl Grey Tea, and " +
                totalLemon    + " boxes of Lemon Tea.";
    }
}
