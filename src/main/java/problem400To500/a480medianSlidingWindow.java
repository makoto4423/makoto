package problem400To500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 二分查找，维护一个有序数列，通过二分进行删增
public class a480medianSlidingWindow {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length, index = 0;
        double[] res = new double[n - k + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        if (k % 2 == 0) {
            res[index++] = ((long) list.get(k / 2 - 1) + (long) list.get(k / 2)) / 2.0;
        } else {
            res[index++] = (double) list.get(k / 2);
        }
        for (int i = k; i < n; i++) {
            remove(list, nums[i - k]);
            add(list, nums[i]);
            if (k % 2 == 0) {
                res[index++] = ((long) list.get(k / 2 - 1) + (long) list.get(k / 2)) / 2.0;
            } else {
                res[index++] = (double) list.get(k / 2);
            }
        }
        return res;
    }

    public void remove(List<Integer> list, int pre) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            if (list.get(l) == pre) {
                list.remove(l);
                return;
            }
            if (list.get(r) == pre) {
                list.remove(r);
                return;
            }
            int mid = l + (r - l) / 2;
            if (list.get(mid) == pre) {
                list.remove(mid);
                return;
            }
            if (list.get(mid) < pre) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    public void add(List<Integer> list, int cur) {
        if(list.isEmpty()) {
            list.add(cur);
            return;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l) >= cur) {
                list.add(l, cur);
                return;
            }
            if (list.get(r) <= cur) {
                list.add(r + 1, cur);
                return;
            }
            int mid = l + (r - l) / 2;
            if (list.get(mid) == cur) {
                list.add(mid, cur);
                return;
            }
            if (list.get(mid) < cur) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (list.get(l) >= cur) {
            list.add(l, cur);
        } else {
            list.add(l + 1, cur);
        }
    }
}
