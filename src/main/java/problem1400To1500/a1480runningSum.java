package problem1400To1500;

public class a1480runningSum {
    public int[] runningSum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = dp[i-1]+nums[i];
        }
        return dp;
    }
}
