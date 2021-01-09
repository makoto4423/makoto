package problem900To1000;

public class a915partitionDisjoint {
    public int partitionDisjoint(int[] A) {
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = A[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(A[i], left[i - 1]);
        }
        right[len - 1] = A[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.min(A[i], right[i + 1]);
        }
        int i = 0;
        for (; i < len - 2; i++) {
            if (left[i] <= right[i + 1]) break;
        }
        return i + 1;
    }
}
