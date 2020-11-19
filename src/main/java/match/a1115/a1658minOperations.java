package match.a1115;

import java.util.Arrays;

// 题解写的也太多莫名其妙的代码了吧。。。
@Deprecated
public class a1658minOperations {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int left = 0, right = 0, cur = 0, len = nums.length, part = -1;
        if (sum < x) return -1;
        while (left < len) {
            if (right < len) {
                cur += nums[right++];
            }
            while (cur > sum - x) {
                cur -= nums[left++];
            }
            if (cur == sum - x) {
                part = Math.max(part, right - left);
            }
            if (right == len) break;
        }
        return part == 0 ? -1 : len - part;
    }
}
