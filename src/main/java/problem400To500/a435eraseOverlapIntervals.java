package problem400To500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Deprecated
public class a435eraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        int right = intervals[0][1];
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                m++;
                right = intervals[i][1];
            }
        }
        return n - m;
    }

}
