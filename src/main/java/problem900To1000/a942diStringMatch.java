package problem900To1000;

import java.util.Arrays;
import java.util.Comparator;

// 暴力的越来越熟练了
public class a942diStringMatch {
    public int[] diStringMatch(String S) {
        int len = S.length();
        int low = 0, high = len;
        int[] res = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = low++;
            } else {
                res[i] = high--;
            }
        }
        res[len] = low;
        return res;
//        int len = S.length();
//        if (len == 0) return new int[]{};
//        int[][] arr = new int[len+1][2];
//        for (int i = 1; i <= len; i++) {
//            arr[i][0] = arr[i - 1][0] + (S.charAt(i - 1) == 'I' ? 1 : -1);
//            arr[i][1] = i;
//        }
//        Arrays.sort(arr, Comparator.comparingInt(o->o[0]));
//        int[] res = new int[len+1];
//        for(int i=0;i<=len;i++){
//            res[arr[i][1]] = i;
//        }
//        return res;
    }
}
