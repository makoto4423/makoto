package problem900To1000;

import java.util.Arrays;

public class a977sortedSquares {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            res[i] = A[i]*A[i];
        }
        Arrays.sort(res);
        return res;
    }
}
