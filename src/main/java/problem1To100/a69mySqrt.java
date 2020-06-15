package problem1To100;

// 令人吐血的隐形类型转换，(long) mid*mid 不会发生溢出, (long) (mid*mid) 在乘法发生以后就已经溢出
public class a69mySqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1 || x == 2) return 1;
        int left = 1, right = x / 2,res = -1;
        while (left <= right) {
            int mid = (right+left)/2;
            if((long) mid*mid<=x){
                res = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return res;
    }

}
