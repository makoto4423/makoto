package problem1To100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 完犊子，越写越蠢了，a56merge的代码，7个月前写出来，现在不会了
public class a57insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] merge = new int[len+1][2];
        System.arraycopy(intervals, 0, merge, 0, len);
        merge[len] = newInterval;
        if(merge.length < 2)    return merge;
        int cnt=0;
        for(int i=0; i<merge.length-1; i++){
            for(int j=i+1; j<merge.length; j++){
                if(i!=j && merge[i] != null && merge[j] != null
                        && merge[i][0] <= merge[j][1]
                        && merge[i][1] >= merge[j][0]){
                    merge[j][0] = Math.min(merge[i][0],merge[j][0]);
                    merge[j][1] = Math.max(merge[i][1],merge[j][1]);
                    merge[i] = null;
                    cnt++;
                    break;
                }
            }
        }
        int[][] res = new int[merge.length-cnt][2];
        int i=0;
        for(int[] ints: merge){
            if(ints != null) res[i++] = ints;
        }
        Arrays.sort(res, Comparator.comparingInt(o -> o[0]));
        return res;
    }
}
