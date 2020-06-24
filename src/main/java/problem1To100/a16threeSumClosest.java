package problem1To100;

import java.util.Arrays;

public class a16threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int dif = Integer.MAX_VALUE, real = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int amount = nums[i] + nums[left] + nums[right];
                if (amount == target) return target;
                if (dif > Math.abs(amount - target)) {
                    dif = Math.abs(amount - target);
                    real = amount;
                }
                if (amount >= target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return real;
    }
}
