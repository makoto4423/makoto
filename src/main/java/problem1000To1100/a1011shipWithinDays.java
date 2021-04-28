package problem1000To1100;

import java.util.Arrays;

// 二分
@Deprecated
public class a1011shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int l = Arrays.stream(weights).max().orElse(-1),
                r = Arrays.stream(weights).sum();
        while (l <= r) {
            int need = 0, cur = 0;
            int mid = (r - l) / 2 + l;
            for (int w : weights) {
                if (cur + w > mid) {
                    cur = w;
                    need++;
                } else {
                    cur += w;
                }
            }
            need++;
            if (need > D) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
