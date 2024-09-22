public class Complaint {
    private String causeOfAction;
    private String plaintiffCitizenship;
    private String defendantCitizenship;
    private String originalStateOfFillings;
    private double amountInControversy;
    private int    id;
    private static int nextId = 1;

//    ----Setters
    void idSet                      (int      x) { id                      =  x;   }
    void amountInControversySet     (double   x) { amountInControversy     =  x;   }
    void causeOfActionSet           (String str) { causeOfAction           =  str; }
    void plaintiffCitizenshipSet    (String str) { plaintiffCitizenship    =  str; }
    void defendantCitizenshipSet    (String str) { defendantCitizenship    =  str; }
    void originalStateOfFillingsSet (String str) { originalStateOfFillings =  str; }

//    ----Getters
    int    idGet                      () { return id;                      }
    double amountInControversyGet     () { return amountInControversy;     }
    String causeOfActionGet           () { return causeOfAction;           }
    String plaintiffCitizenshipGet    () { return plaintiffCitizenship;    }
    String defendantCitizenshipGet    () { return defendantCitizenship;    }
    String originalStateOfFillingsGet () { return originalStateOfFillings; }

    Complaint (String causeOfAction, double amountInControversy, String plaintiffCitizenship, String defendantCitizenship, String originalStateOfFillings) {
        id                      = nextId++;
        this.causeOfAction           = causeOfAction;
        this.amountInControversy     = amountInControversy;
        this.plaintiffCitizenship    = plaintiffCitizenship;
        this.defendantCitizenship    = defendantCitizenship;
        this.originalStateOfFillings = originalStateOfFillings;
    }


}
