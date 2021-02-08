package problem900To1000;

// 假期懒得想了，滑动窗口，动态规划
@Deprecated
public class a978maxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0, right = 0, n = arr.length, res = 1;
        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right] > arr[right + 1] && arr[right] > arr[right - 1]) {
                    right++;
                } else if (arr[right] < arr[right + 1] && arr[right] < arr[right - 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
