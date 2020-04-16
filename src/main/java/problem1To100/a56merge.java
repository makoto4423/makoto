package problem1To100;

import java.util.*;

public class a56merge {

    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)    return intervals;
        int cnt=0;
        for(int i=0; i<intervals.length-1; i++){
            for(int j=i+1; j<intervals.length; j++){
                if(i!=j && intervals[i] != null && intervals[j] != null
                        && intervals[i][0] <= intervals[j][1]
                        && intervals[i][1] >= intervals[j][0]){
                    intervals[j][0] = Math.min(intervals[i][0],intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1],intervals[j][1]);
                    intervals[i] = null;
                    cnt++;
                    break;
                }
            }
        }
        int[][] res = new int[intervals.length-cnt][2];
        int i=0;
        for(int[] ints: intervals){
            if(ints != null) res[i++] = ints;
        }
        return res;
    }

}
