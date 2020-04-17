package problem1To100;

public class a55canJump {
    public boolean canJump(int[] nums) {
        if(nums.length<2)   return true;
        int right = nums[0];
        for(int i=1;i<nums.length; i++){
            if(i<=right){
                right = Math.max(right, i+nums[i]);
                if(right >= nums.length)    return true;
            }
        }
        return false;
        // 最优解为贪心，dp会重复计算，且需要额外的空间
//        if(nums.length < 2) return true;
//        boolean[] dp = new boolean[nums.length];
//        dp[0] = true;
//        for(int i=0; i<nums.length; i++){
//            int wid = nums[i];
//            if(!dp[i])  return false;
//            for(int j=i; j<nums.length && i+wid>= j; j++ ){
//                dp[j] = true;
//            }
//        }
//        return dp[nums.length-1];
    }
}
