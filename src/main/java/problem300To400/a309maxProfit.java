package problem300To400;


public class a309maxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0)    return 0;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        for(int i=1;i<len;i++){
            // 持有股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
            // 未持有，且处于冷冻期
            dp[i][1] = dp[i-1][0]+prices[i];
            // 未持有，不处于冷冻期
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }
        return Math.max(dp[len-1][1],dp[len-1][2]);
    }
}
