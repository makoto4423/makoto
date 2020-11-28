package problem400To500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 还是懒。。。反序遍历，然后维护一个有序数组，插排用顺序遍历就超时，二分就刚好能过
// 答案用的是归并，不过看了眼时间复杂度是O(n*log2n)，不就和二分一样吗。。
// 然后乖乖回头改插排
public class a493reversePairs {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[len - 1]);
        int res = 0;
        for (int i = len - 2; i >= 0; i--) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                long k = (long) list.get(mid) * 2;
                if (k < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            res += left;
            left = 0;
            right = list.size() - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (list.get(mid) < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            list.add(left, nums[i]);
        }
        return res;
    }
}
