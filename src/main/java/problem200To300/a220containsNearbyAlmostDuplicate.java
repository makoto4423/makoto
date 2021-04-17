package problem200To300;

import java.util.ArrayList;
import java.util.List;

public class a220containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0) return false;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i <= k && i < nums.length; i++) {
            if (insert(list, nums[i], t)) {
                return true;
            }
        }
        for (int i = k + 1; i < nums.length; i++) {
            // 其实这里也应该用二分去手动删除，不过，懒
            // 结果就是三个月前能用的代码现在变超时，还是得二分删啊
            // 不过实际上这里应该用桶
            remove(list, nums[i - k - 1]);
            if (insert(list, nums[i], t)) {
                return true;
            }
        }
        return false;
    }

    public boolean insert(List<Integer> list, int n, int t) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (list.get(mid) == n) {
                return true;
            } else if (list.get(mid) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        list.add(l, n);
        if (l != 0) {
            long dif = (long) list.get(l) - (long) list.get(l - 1);
            if (dif <= t) {
                return true;
            }
        }
        if (l != list.size() - 1) {
            long dif = (long) list.get(l + 1) - (long) list.get(l);
            return dif <= t;
        }
        return false;
    }

    public void remove(List<Integer> list, int val) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (list.get(l) == val) {
                list.remove(l);
                break;
            } else if (list.get(mid) == val) {
                list.remove(mid);
                break;
            } else if (list.get(mid) < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
    }
}
