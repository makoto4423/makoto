package problem300To400;

public class a343integerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<n+1;i++){
            for(int m=1;m<=i/2;m++){
                dp[i] = Math.max(dp[i],Math.max(m,dp[m])*Math.max(i-m,dp[i-m]));
            }
        }
        return dp[n];
    }

}
