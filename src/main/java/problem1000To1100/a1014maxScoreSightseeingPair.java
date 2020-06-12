package problem1000To1100;

@Deprecated
// A[i]+A[j]+i-j = A[i]+i+A[j]-j
public class a1014maxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0,left=A[0];
        for(int j = 1;j<A.length;j++){
            res = Math.max(res,left+A[j]-j);
            left = Math.max(left,A[j]+j);
        }
        return res;
    }
}
