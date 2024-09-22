public class LiveBox extends Box {
    private String animal;
    private int age;

    LiveBox() {
        super();
        animal = "";
        age = 0;
    }
    LiveBox(String deliveryAddress, String returnAddress, double width, double length , double height, int count, String animal, int age) {
        super(deliveryAddress, returnAddress, width, length , height, count);
        this.animal = animal;
        this.age = age;
    }

    void   setAnimal (String animal) {  this.animal = animal;}
    void   setAge    (int age)       {  this.age = age;}
    String getAnimal () { return animal; }
    int    getAge    () { return age   ; }

    public String toString() {
        return getId() + "\n" +
        getDeliveryAddress() + "\n" +
        getReturnAddress() + "\n" +
        getWidth() +  " x " + getLength() + " x " + getHeight() + "\n" +
        "Animal: " + getAnimal() + "\n" +
        "Count: " + getCount() + "\n" +
        "Age (Days):" + getAge();
    }
}
