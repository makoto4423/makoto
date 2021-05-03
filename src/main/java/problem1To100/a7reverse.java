package problem1To100;

public class a7reverse {
    public int reverse(int x) {
        long l = 0;
        while (x != 0) {
            l *= 10;
            l += x % 10;
            x /= 10;
        }
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) l;
    }
}
