package problem1To100;

public class a1twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result;
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result = new int[]{i, j};
                    return result;
                }
            }
        return null;
    }
}
