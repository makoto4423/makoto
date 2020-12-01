package problem1To100;

public class a34searchRange {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return new int[]{-1, -1};
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[left] == target) {
                break;
            } else if (nums[right] == target) {
                left = right;
                break;
            } else if (nums[mid] == target) {
                left = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == len || nums[left] != target) return new int[]{-1, -1};
        int[] res = new int[2];
        int i = left - 1;
        for (; i >= 0; i--) {
            if (nums[i] != target) break;
        }
        if (i != -1) {
            res[0] = i + 1;
        }
        i = left + 1;
        for (; i < len; i++) {
            if (nums[i] != target) break;
        }
        res[1] = i - 1;
        return res;
    }
}
