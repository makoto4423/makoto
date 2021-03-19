package problem500To600;

// 要用单调栈，不过暴力还是过了。。。
public class a503nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            for (; j < 2 * n; j++) {
                if (nums[j % n] > nums[i]) break;
            }
            if (j == 2 * n) {
                arr[i] = -1;
            } else {
                arr[i] = nums[j % n];
            }
        }
        return arr;
    }
}
