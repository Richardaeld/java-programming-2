public abstract class Envelope extends Mail {
    double thickness;

    Envelope () {
        super();
        thickness = 0;
    }

    Envelope (String deliverAddress, String returnAddress, double width, double length, double thickness) {
        super(deliverAddress, returnAddress, width, length);
        this.thickness = thickness;
    }

    double getThickness() {
        return thickness;
    }

    public String toString() {
        return getId() + "\n" +
            getDeliveryAddress() + "\n" +
            getReturnAddress() + "\n" +
            getWidth() + " x " +  getLength() + " x " + getThickness() + "\n";
    }
}
