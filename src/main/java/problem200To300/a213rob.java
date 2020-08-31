package problem200To300;

import java.util.Arrays;

/**
 * 如若智障，打算把数组重复两遍，发现不行，然后又打算蛮力去搞，其实去掉尾，去掉头各算一遍不就好了。。。
 */
@Deprecated
public class a213rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        return Math.max(recur(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                recur(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int recur(int[] num) {
        int pre = 0, cur = 0;
        for (int i : num) {
            int tmp = cur;
            cur = Math.max(pre + i, cur);
            pre = tmp;
        }
        return cur;
    }
}
