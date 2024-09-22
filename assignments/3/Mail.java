public abstract class Mail {
    private String deliveryAddress;
    private String returnAddress;
    private double width;
    private double length;
    private int id;
    private static int nextId = 0;

    Mail () {
        this.deliveryAddress = "";
        this.returnAddress   = "";
        this.width           = 0;
        this.length          = 0;
        this.id              = nextId++;
    }
    Mail (String deliveryAddress, String returnAddress, double width, double length ) {
        this.deliveryAddress = deliveryAddress;
        this.returnAddress   = returnAddress;
        this.width           = width;
        this.length          = length;
        this.id              = nextId++;
    }
// Getters
    String getDeliveryAddress() { return deliveryAddress; }
    String getReturnAddress()   { return returnAddress;   }
    double getWidth()           { return width;           }
    double getLength()          { return length;          }
    int    getId()              { return id;              }
// Setters
    void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
    void setReturnAddress(String returnAddress)     { this.returnAddress = returnAddress;     }
    void setWidth(double width)                     { this.width = width;                     }
    void setLength(double length)                   { this.length = length;                   }
    void setId(int id)                              { this.id = id;                           }
// Methods
    @Override
    public String toString() {
        return
            id + "/n" +
            deliveryAddress + "/n" +
            returnAddress;
    }
}
