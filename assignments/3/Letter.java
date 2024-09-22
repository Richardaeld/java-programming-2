public class Letter extends Envelope {
    private String letterBody;

    Letter () {
        super();
        letterBody = "";
    }
    Letter (String deliveryAddress, String returnAddress, double width, double length, double thickness, String letterBody) {
        super(deliveryAddress, returnAddress, width, length, thickness);
        this.letterBody = letterBody;
    }
    String getLetterBody() { return letterBody; }
}
