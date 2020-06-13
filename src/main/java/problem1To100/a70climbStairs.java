package problem1To100;

// 第n次写爬楼梯
// 有更好的解决办法，涉及到线性代数
// https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
public class a70climbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;dp[1] =1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
