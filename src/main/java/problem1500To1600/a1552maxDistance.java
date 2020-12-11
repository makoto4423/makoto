package problem1500To1600;

import java.util.*;

// 回溯超时
@Deprecated
public class a1552maxDistance {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int x, int[] p, int m) {
        int cnt = 1, pre = p[0];
        for (int i = 1; i < p.length; i++) {
            if (p[i] - pre >= x) {
                pre = p[i];
                cnt++;
            }
        }
        return cnt >= m;
    }
}
