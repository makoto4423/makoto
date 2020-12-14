package problem300To400;

public class a396maxRotateFunction {
    public int maxRotateFunction(int[] A) {
        long sum = 0;
        for (int i : A) {
            sum += i;
        }
        int len = A.length;
        if (len == 0) return 0;
        int res = Integer.MIN_VALUE;
        long[] dp = new long[len];
        for (int i = 1; i < len; i++) {
            dp[i] = sum - A[len - i] - (len - 1) * A[len - i];
        }
        int temp = 0;
        for (int i = 1; i < len; i++) {
            temp += i * A[i];
        }
        for (long i : dp) {
            temp += i;
            res = Math.max(res, temp);
        }
        return res;
    }
}
