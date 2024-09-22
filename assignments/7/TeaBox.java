public class TeaBox {
    private String teaType = null;
    private TeaBox nextTea = null;

    TeaBox (String teaType, TeaBox nextTea) {
        this.teaType = teaType;
        this.nextTea = nextTea;
    }

    String teaTypeGet () { return teaType; }
    TeaBox nextTeaGet () { return nextTea; }

    void teaTypeSet (String teaType) { this.teaType = teaType; }
    void nextTeaSet (TeaBox nextTea) { this.nextTea = nextTea; }

}
