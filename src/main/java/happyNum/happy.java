package happyNum;

public class happy {
    public boolean isHappy(int n) {
        int cnt = count(n);
        return cnt == 1;
    }

    public int count(int n){
        int count = split(n);
        if(10 > count) return count;
        return count(count);
    }

    public int split(int n){
        int cnt = 0;
        while(n/10 > 0){
            cnt += (n%10)*(n%10);
            n /= 10;
        }
        return cnt;
    }
}
