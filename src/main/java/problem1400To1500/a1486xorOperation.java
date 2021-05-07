package problem1400To1500;

public class a1486xorOperation {

    public int xorOperation(int n, int start) {
        int i = 1;
        int val, res = start;
        while (i < n) {
            val = start + 2 * i;
            res ^= val;
            i++;
        }
        return res;
    }

}
