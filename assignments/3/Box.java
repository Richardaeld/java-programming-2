public abstract class Box extends Mail {
    private double height;
    private int count;

    Box () {
        super();
        double height = 0;
        int    count  = 0;
    }
    Box (String deliveryAddress, String returnAddress, double width, double length , double height, int count) {
        super(deliveryAddress, returnAddress, width, length);
        this.height = height;
        this.count = count;
    }

    double getHeight () {return height;}
    int    getCount  () {return count;}

    void setHeight(double height) {this.height = height;}
    void setCount (int count)     {this.count  = count ;}

    public String toString () {
        return getId()           + "\n" +
            getDeliveryAddress() + "\n" +
            getReturnAddress()   + "\n" +
            getWidth() + " x " + getLength() + " x " + getHeight();
    }

}
