package offer;

public class a17printNumbers {
    public int[] printNumbers(int n) {
        if (n < 1) return new int[]{};
        int top = 1;
        for (int i = 0; i < n; i++) {
            top *= 10;
        }
        int[] res = new int[top-1];
        for (int i = 1; i < top; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
