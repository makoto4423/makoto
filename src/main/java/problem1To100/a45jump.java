package problem1To100;

import java.util.Arrays;
// 第一次做出困难，不过这dp撑死算中级
public class a45jump {
    public int jump(int[] nums) {
        if(nums.length<2) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            for(int j=1;j<=num&&i+j<nums.length;j++){
                dp[i+j] = Math.min(dp[i+j],dp[i]+1);
            }
        }
        return dp[nums.length-1];
    }
}
