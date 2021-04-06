package problem1To100;

import java.util.Arrays;

// 一年前能通过的代码一年后报错了。。。。
public class a80removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int dupSize = 0, size = nums.length;
        if (size < 2) return size;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > nums[i + 1]) break;
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                System.arraycopy(nums, i + 2 + 1, nums, i + 2, size - i - 3);
                nums[size - dupSize - 1] = -1;
                i--;
                dupSize++;
            }
        }
        return size - dupSize;
    }
}
