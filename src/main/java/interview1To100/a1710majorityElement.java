package interview1To100;

import java.util.Arrays;

public class a1710majorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<=nums.length/2;i++){
            if((nums.length/2+i < nums.length) && nums[i] == nums[nums.length/2+i]){
                return nums[i];
            }
        }
        return -1;
    }
}
