package problem1100To1200;

// 分情况讨论，然后转化成数学题
@Deprecated
public class a1131maxAbsValExpr {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE, minC = Integer.MAX_VALUE, minD = Integer.MAX_VALUE;
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE, maxD = Integer.MIN_VALUE;
        int len = arr1.length;
        for (int i = 0; i < len; i++) {
            maxA = Math.max(maxA, arr1[i] + arr2[i] + i);
            minA = Math.min(minA, arr1[i] + arr2[i] + i);
            maxB = Math.max(maxB, arr1[i] + arr2[i] - i);
            minB = Math.min(minB, arr1[i] + arr2[i] - i);
            maxC = Math.max(maxC, arr1[i] - arr2[i] + i);
            minC = Math.min(minC, arr1[i] - arr2[i] + i);
            maxD = Math.max(maxD, arr1[i] - arr2[i] - i);
            minD = Math.min(minD, arr1[i] - arr2[i] - i);
        }
        int m = Math.max(maxA - minA, maxB - minB);
        int n = Math.max(maxC - minC, maxD - minD);
        return Math.max(m, n);
    }
}
