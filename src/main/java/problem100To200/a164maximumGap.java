package problem100To200;

import java.util.Arrays;

// 既然基数排序的复杂度是O(n)，那为什么jdk还要用归并O(n log n) ?
@Deprecated
public class a164maximumGap {

    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] buf = new int[len];
        int exp = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        while (max >= exp) {
            int[] arr = new int[10];
            for (int i : nums) {
                arr[(i / exp) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                arr[i] += arr[i - 1];
            }
            for (int i = len - 1; i >= 0; i--) {
                buf[arr[nums[i] / exp % 10]-1] = nums[i];
                arr[nums[i] / exp % 10]--;
            }
            exp *= 10;
            System.arraycopy(buf, 0, nums, 0, len);
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            res = Math.max(res, Math.abs(nums[i] - nums[i - 1]));
        }
        return res;
    }


//    public int maximumGap(int[] nums) {
//        if (nums.length < 2) return 0;
//        Arrays.sort(nums);
//        int res = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
//        }
//        return res;
//    }
}
