package problem200To300;

public class a283moveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                for (; j < len; j++) {
                    if (nums[j] != 0) break;
                }
                if (j == len) return;
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }
}
