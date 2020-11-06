package problem1300To1400;

import java.util.Arrays;
import java.util.Comparator;

public class a1356sortByBits {
    public int[] sortByBits(int[] arr) {
        Integer[] res = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        Arrays.sort(res, (o1, o2) -> {
            int cnt1 = 0, cnt2 = 0;
            int v1 = o1, v2 = o2;
            while (v1 != 0) {
                cnt1 += v1 % 2;
                v1 /= 2;
            }
            while (v2 != 0) {
                cnt2 += v2 % 2;
                v2 /= 2;
            }
            if (cnt1 != cnt2) {
                return cnt1 - cnt2;
            } else {
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
        return arr;
    }
}
