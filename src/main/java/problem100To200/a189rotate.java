package problem100To200;

public class a189rotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        while (k > 0) {
            int last = nums[n - 1];
            System.arraycopy(nums, 0, nums, 1, n - 1);
            nums[0] = last;
            k--;
        }
    }
}
