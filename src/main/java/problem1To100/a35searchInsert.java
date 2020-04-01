package problem1To100;

public class a35searchInsert {

    public int searchInsert(int[] nums, int target) {
        if(1 >= nums.length)
            return nums[0] >= target ? 0 : 1;
        boolean desc = false;
        if(nums[0] > nums[1])   desc = true;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target)   return i;
            if(desc){
                if(target > nums[i]) return i;
            }else{
                if(nums[i] > target) return i;
            }
        }
        return nums.length;
    }

}
