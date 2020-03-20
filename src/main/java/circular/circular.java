package circular;

public class circular {

    public static void main(String[] args){
        A a = new A();
        B b = new B();
        C c = new C();
        a.setB(b);b.setC(c);c.setA(a);
        a.test();
    }

}
