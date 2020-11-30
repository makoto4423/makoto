package problem300To400;

// 参考近乎暴力的，奈何归并的看不懂
@Deprecated
public class a327countRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        int res = 0;
        long[] dp = new long[len];
        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
            if (dp[i] >= lower && dp[i] <= upper) {
                res++;
            }
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[i] += nums[j];
                if (dp[i] >= lower && dp[i] <= upper) {
                    res++;
                }
            }
        }
        return res;
    }
}
