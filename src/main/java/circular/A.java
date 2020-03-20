package circular;

public class A {
    public void test(){
        b.test();
    }
    private B b;
    public void setB(B b){
        this.b = b;
    }

}
