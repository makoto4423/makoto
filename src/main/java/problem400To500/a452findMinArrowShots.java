package problem400To500;

import java.util.Arrays;
import java.util.Comparator;

public class a452findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0],o2[0]);
            }
            return Integer.compare(o1[1],o2[1]);
        });
        int res = points.length;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int j = i + 1;
            for (; j < points.length; j++) {
                if (points[j][0] > p[1]) break;
                p[1] = Math.min(points[j][1],p[1]);
            }
            j--;
            res -= j - i;
            i = j;
        }
        return res;
    }
}
