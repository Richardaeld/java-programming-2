public class RegularBox extends Box {
    private String items;
    private double weight;

    RegularBox() {
        super();
        items = "";
        weight = 0;
    }
    RegularBox(String deliveryAddress, String returnAddress, double width, double length, double height, int count, String items, double weight) {
        super(deliveryAddress, returnAddress, width, length, height, count);
        this.items = items;
        this.weight = weight;
    }

    String getItems  () {return items;}
    double getWeight () {return weight; }

    void setItems  () { this.items = items;   }
    void setWeight () { this.weight = weight; }

    public String toString() {
        return getId() + "\n" +
            getDeliveryAddress() + "\n" +
            getReturnAddress() + "\n" +
            getWidth() + " x " + getLength() + " x " + getHeight() + "\n" +
            "Items:"  + getItems() + "\n"   +
            "Count:"  + getCount() + "\n" +
            "Weight:" + getWeight();
    }
}
