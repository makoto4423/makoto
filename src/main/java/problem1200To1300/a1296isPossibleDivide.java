package problem1200To1300;

import java.util.Arrays;

public class a1296isPossibleDivide {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums == null || nums.length == 0)    return true;
        if(nums.length % k != 0)    return false;
        Arrays.sort(nums);
        int size = nums.length/k;
        while(size != 0){
            int cnt=1, start = Integer.MAX_VALUE;
            for(int i=0; i<nums.length; i++){
                if(nums[i] != Integer.MAX_VALUE){
                    start = nums[i];
                    nums[i] = Integer.MAX_VALUE;
                    break;
                }
            }
            for(int i=0; i<nums.length && cnt != k; i++){
                if(nums[i] == start+1){
                    start = nums[i];
                    nums[i] = Integer.MAX_VALUE;
                    cnt++;
                }
            }
            if(cnt == k){
                size--;
            }else{
                return false;
            }
        }
        return true;
    }
}
