package problem700To800;

public class a724pivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + nums[i];
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int l = 0, r = 0;
            if (i != 0) {
                l = left[i - 1];
            }
            if (i != n - 1) {
                r = right[i + 1];
            }
            if (l == r) {
                return i;
            }
        }
        return -1;
    }
}
