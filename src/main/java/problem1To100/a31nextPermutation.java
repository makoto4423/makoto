package problem1To100;

public class a31nextPermutation {
    public void nextPermutation(int[] nums) {
        int change = -1, move = -1, len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (j > change) {
                        change = j;
                        move = i;
                        break;
                    }
                }
            }
        }
        if (change != -1){
            int temp = nums[change];
            nums[change] = nums[move];
            nums[move] = temp;
        }
        for (int i = change + 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
