package problem1To100;

public class a26removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1)    return nums.length;
        int i = 0,j=1;
        for(;i<nums.length&&j<nums.length;){
            if(nums[i] == nums[j]){
                j++;
            }else if(j-i != 1){
                nums[i+1] = nums[j];i++;j++;
            }else {
                i++;j++;
            }
        }
        return i+1;
    }
}
