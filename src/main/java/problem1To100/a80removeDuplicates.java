package problem1To100;

import java.util.Arrays;

public class a80removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int dupSize = 0,size=nums.length;
        if(size < 2)    return size;
        for(int i=0; i<nums.length-2;i++){
            if(nums[i]>nums[i+1]) break;
            if(nums[i] == nums[i+1] && nums[i] == nums[i+2]){
                if (size - dupSize - 1 - i + 2 >= 0)
                    System.arraycopy(nums, i + 2 + 1, nums, i + 2, size - dupSize - 1 - i + 2);
                i--;
                nums[size-dupSize-1] = -1;
                dupSize++;
            }
        }
        return size-dupSize;
    }
}
