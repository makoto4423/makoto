package problem1200To1300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 吐了，一道middle给我写成了hard的感觉
public class a1262maxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        int res = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int v = nums[i];
            int a = v % 3;
            if (a == 0) {
                res += v;
            } else {
                list.get(a).add(v);
            }
        }
        List<Integer> l1 = list.get(1);
        List<Integer> l2 = list.get(2);
        Collections.sort(l1);
        Collections.sort(l2);
        while (l1.size() > 4) {
            res += l1.get(l1.size() - 1) + l1.get(l1.size() - 2) + l1.get(l1.size() - 3);
            l1.remove(l1.size() - 1);
            l1.remove(l1.size() - 1);
            l1.remove(l1.size() - 1);
        }
        while (l2.size() > 4) {
            res += l2.get(l2.size() - 1) + l2.get(l2.size() - 2) + l2.get(l2.size() - 3);
            l2.remove(l2.size() - 1);
            l2.remove(l2.size() - 1);
            l2.remove(l2.size() - 1);
        }
        List<Integer> less = l1.size() >= l2.size() ? l2 : l1;
        List<Integer> more = l1.size() >= l2.size() ? l1 : l2;
        if (less.size() == more.size() || less.size() + 3 == more.size()) {
            for (int i : less) {
                res += i;
            }
            for (int i : more) {
                res += i;
            }
        } else if ((less.size() == 1 && more.size() == 2)
                || (less.size() == 3 && more.size() == 4)) {
            // less : 0 ; more : 1
            for (int i : less) {
                res += i;
            }
            for (int i = 1; i < more.size(); i++) {
                res += more.get(i);
            }
        } else if (less.size() == 1 && more.size() == 3) {
            // less : 1 ; more : 0
            int v1 = more.get(0) + more.get(1) + more.get(2);
            // less : 0 ; more : 2
            int v2 = more.get(2) + less.get(0);
            res += Math.max(v1, v2);
        } else if (less.size() == 2 && more.size() == 3) {
            // less : 2 ; more : 0
            int v1 = 0;
            for (int i : more) {
                v1 += i;
            }
            // less : 0 ; more : 1
            int v2 = less.get(0) + less.get(1) + more.get(1) + more.get(2);
            res += Math.max(v1, v2);
        } else if (less.size() == 2 && more.size() == 4) {
            // less : 0 ; more : 2
            int v1 = less.get(0) + less.get(1) + more.get(2) + more.get(3);
            // less : 1 ; more : 0
            int v2 = less.get(1) + more.get(0) + more.get(1) + more.get(2) + more.get(3);
            res += Math.max(v1, v2);
        } else if (less.size() == 0 && more.size() > 2) {
            if (more.size() == 3) {
                res += more.get(0) + more.get(1) + more.get(2);
            } else if (more.size() == 4) {
                res += more.get(1) + more.get(2) + more.get(3);
            }
        }
        return res;
    }
}
