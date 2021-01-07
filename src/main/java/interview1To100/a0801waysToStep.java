package interview1To100;

public class a0801waysToStep {
    public int waysToStep(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n==3) return 4;
        int a = 1,b=2,c=4;
        while (n > 3){
            int temp = (a+b)%1000000007;
            temp = (temp+c)%1000000007;
            a = b;
            b = c;
            c = temp;
            n--;
        }
        return c;
    }
}
