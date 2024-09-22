public class Flat extends Envelope {
    private String contents;

    Flat() {
        super();
        contents = "";
    }
    Flat (String deliveryAddress, String returnAddress, double width, double length, double thickness, String contents) {
        super(deliveryAddress, returnAddress, width, length, thickness);
        this.contents = contents;
    }

    String getContents () { return contents; }

}
