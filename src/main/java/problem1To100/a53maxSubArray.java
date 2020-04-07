package problem1To100;

public class a53maxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)    return 0;
        int[] cp = new int[nums.length];
        cp[0] = nums[0];
        int max = cp[0];
        for(int i=1; i<nums.length; i++){
            cp[i] = Math.max(cp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, cp[i]);
        }
        return max;
    }
}
