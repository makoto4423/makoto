package problem900To1000;

import java.util.Arrays;
import java.util.Comparator;

public class a973kClosest {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        if (len <= K) {
            return points;
        }
        if (K == 0) {
            return new int[][]{};
        }
        int[][] temp = new int[len][2];
        for (int i = 0; i < len; i++) {
            int[] p = points[i];
            temp[i][0] = p[0] * p[0] + p[1] * p[1];
            temp[i][1] = i;
        }
        Arrays.sort(temp, Comparator.comparingInt(o -> o[0]));
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[temp[i][1]];
        }
        return res;
    }
}
