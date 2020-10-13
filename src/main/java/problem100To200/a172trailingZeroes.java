package problem100To200;

/**
 * 就是找规律。。。
 */
@Deprecated
public class a172trailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
