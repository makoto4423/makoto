package problem200To300;

@Deprecated
public class a287findDuplicate {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1, res = 0;
        while (left <= right) {
            int cnt = 0;
            int mid = (left + right) >> 1;
            for (int i : nums) {
                if (i <= mid) cnt++;
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}
