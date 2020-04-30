package problem1200To1300;

import java.util.Arrays;

@Deprecated
public class a1262maxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int amount = 0;
        for(int num : nums){
            amount += num;
        }
        if(amount%3==0) return amount;
        int more = amount%3;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j< nums.length; j++){
                if(nums[j]%3==more) return amount-nums[j];
            }
            amount-=nums[i];
            more = amount%3;
        }
        return 0;
    }
}
