package match;

/**
 * 毫无意外的timeout
 */
@Deprecated
public class a5471maxNonOverlapping {
    public int maxNonOverlapping(int[] nums, int target) {
        int[] dp = new int[nums.length];
        int res = 0;
        for(int i=0;i<nums.length;i++){
            int tempRes = 0;
            for(int m = 0;m<i;m++){
                tempRes = Math.max(tempRes, dp[m]);
            }
            int temp = 0;
            for(int j=i;j<nums.length;j++){
                temp += nums[j];
                if(temp == target){
                    tempRes++;
                    dp[j] = Math.max(dp[j],tempRes);
                    temp = 0;
                }
            }
            res = Math.max(res, tempRes);
        }
        return res;
    }
}
