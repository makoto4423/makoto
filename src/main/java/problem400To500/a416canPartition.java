package problem400To500;

/**
 * 动态规划，dp
 */
@Deprecated
public class a416canPartition {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;
        int amount = 0, max = -1;
        for (int i : nums) {
            amount += i;
            max = Math.max(i, max);
        }
        int target = amount / 2;
        if (amount % 2 != 0 || max > target) {
            return false;
        }
        boolean[][] arr = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            arr[i][0] = true;
        }
        arr[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j > num) {
                    arr[i][j] = arr[i - 1][j] | arr[i - 1][j - num];
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        return arr[len - 1][target];
    }

//
//    boolean tag;
//    public boolean canPartition(int[] nums) {
//        int amount = 0;
//        for(int i : nums){
//            amount += i;
//        }
//        if(amount%2 != 0)   return false;
//        amount /= 2;
//        tag = false;
//        recur(0,nums,amount);
//        return tag;
//    }
//
//    public void recur(int i,int[] num,int amount){
//        if(tag) return;
//        if(amount <= 0){
//            tag = amount == 0;
//            return;
//        }
//        for(int m = i;m<num.length;m++){
//            recur(m+1,num,amount-num[m]);
//            recur(m+1,num,amount);
//        }
//    }
}
