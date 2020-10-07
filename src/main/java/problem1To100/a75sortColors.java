package problem1To100;

public class a75sortColors {
    public void sortColors(int[] nums) {
        int a = 0, b = 0;
        for (int i : nums) {
            if (i == 0) {
                a++;
            } else if (i == 1) {
                b++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (a != 0) {
                nums[i] = 0;
                a--;
            } else if (b != 0) {
                nums[i] = 1;
                b--;
            } else {
                nums[i] = 2;
            }
        }
    }
}
