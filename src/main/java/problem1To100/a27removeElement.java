package problem1To100;

public class a27removeElement {

    public int removeElement(int[] nums, int val) {
        int unnecessary = 0;
        for (int i = 0; i < nums.length - unnecessary; i++) {
            if (nums[i] == val) {
                unnecessary++;
                System.arraycopy(nums, i + 1, nums, i, nums.length - unnecessary - i);
                i--;
            }
        }
        return nums.length - unnecessary;
    }

}
