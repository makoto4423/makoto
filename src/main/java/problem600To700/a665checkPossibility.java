package problem600To700;

public class a665checkPossibility {

    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) break;
        }
        if (i == n - 1) {
            return true;
        }
        int temp = nums[i + 1], pre = i;
        nums[i + 1] = nums[i];
        for (; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) break;
        }
        if (i != n - 1) {
            i = pre;
            nums[i + 1] = temp;
            if (i != 0) {
                if (nums[i + 1] < nums[i - 1]) return false;
            }
            nums[i] = temp;
            for (; i < n - 1; i++) {
                if (nums[i] > nums[i + 1]) break;
            }
        }
        return i == n - 1;
    }

}
