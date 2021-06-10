package problem500To600;

import java.util.Arrays;

// 动态规划
@Deprecated
public class a518change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }
}
