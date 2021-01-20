package problem600To700;

import java.util.Arrays;

public class a628maximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        if (nums[0] < 0 && nums[1] < 0) {
            res = nums[0] * nums[1] * nums[n - 1];
        }
        res = Math.max(res, nums[n - 3] * nums[n - 2] * nums[n - 1]);
        return res;
    }
}
