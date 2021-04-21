package problem1To100;

// dp问题，然而我还是写成递归
// lc又更新了测试用例，递归超时
@Deprecated
public class a91numDecodings {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') < 27)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }


}
