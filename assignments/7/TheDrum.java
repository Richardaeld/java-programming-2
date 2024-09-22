public class TheDrum {
    private TeaBox nextTeaBox = null;


    TheDrum (int jasmine, int earlGrey, int lemon) {
        for(int i = 0; i < jasmine;  i++) { nextTeaBox = new TeaBox("jasmine" , nextTeaBox); }
        for(int i = 0; i < earlGrey; i++) { nextTeaBox = new TeaBox("earlGrey", nextTeaBox); }
        for(int i = 0; i < lemon;    i++) { nextTeaBox = new TeaBox("lemon"   , nextTeaBox); }
    }


//    pop
    public TeaBox nextTeaBoxGet () {
        try {
            nextTeaBox = nextTeaBox.nextTeaGet();
        } catch (NullPointerException e) {
            return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return nextTeaBox;
    }

}
