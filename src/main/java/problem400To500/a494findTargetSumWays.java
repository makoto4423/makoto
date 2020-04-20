package problem400To500;

import java.util.ArrayList;
import java.util.List;

public class a494findTargetSumWays {
    int cnt=0;
    public int findTargetSumWays(int[] nums, int S) {
        recur(0,nums,S-nums[0]);
        recur(0,nums,S+nums[0]);
        return cnt;
    }

    public void recur(int p, int[] nums, int S){
        if(p == nums.length-1){
            if(S == 0){
                ++cnt;
            }
            return ;
        }
        recur(p+1,nums,S+nums[p+1]);
        recur(p+1,nums,S-nums[p+1]);
    }

}
