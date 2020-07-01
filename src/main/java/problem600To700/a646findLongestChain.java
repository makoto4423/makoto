package problem600To700;

import java.util.Arrays;
import java.util.Comparator;

public class a646findLongestChain {
    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0)   return 0;
//        for(int i=0;i<pairs.length;i++){
//            for(int j=i+1;j<pairs.length;j++){
//                if(pairs[i][1]>pairs[j][1]){
//                    int[] temp = pairs[i];
//                    pairs[i] = pairs[j];
//                    pairs[j] = temp;
//                }else if(pairs[i][1] == pairs[j][1] && pairs[i][0] > pairs[j][0]){
//                    int[] temp = pairs[i];
//                    pairs[i] = pairs[j];
//                    pairs[j] = temp;
//                }
//            }
//        }
        // 不会用sort，导致耗时长，用了从92ms -> 13ms
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int res = 1,pre = pairs[0][1];
        for(int[] p : pairs){
            if(p[0] > pre){
                res++;
                pre = p[1];
            }
        }
        return res;
    }
}
