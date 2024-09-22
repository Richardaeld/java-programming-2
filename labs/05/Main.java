class Main {
  public static void main(String[] args) {

    //Note the polymorphism:
    A myB = new B();
    myB.do_stuff1();
    // myB.do_stuff2();
  }
}

abstract class A {
  public int do_stuff1() {
    return 3;
  }
}
 
class B extends A {
  @Override
  public int do_stuff1() {
    return 4;
  }
 
  // public int do_stuff2() {
  //   return 7;
  // }
}
 


