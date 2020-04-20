package problem200To300;

public class a258addDigits {
    public int addDigits(int num) {
        while (num / 10 != 0){
            int a = num;
            int cnt = 0;
            while( a !=  0){
                cnt += a%10;
                a = a/10;
            }
            num = cnt;
        }
        return num;
    }
}
