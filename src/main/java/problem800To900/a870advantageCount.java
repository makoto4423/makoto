package problem800To900;

import java.util.*;

public class a870advantageCount {
    public int[] advantageCount(int[] A, int[] B) {
        int len = B.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i] = new int[]{B[i], i};
        }
        Arrays.sort(A);
        boolean[] visited = new boolean[len];
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int i = 0, j = 0;
        while (i < len) {
            if (A[i] > arr[j][0]) {
                visited[i] = true;
                arr[j++][0] = A[i];
            }
            i++;
        }
        i = 0;
        while (i < len) {
            if (!visited[i]) {
                arr[j++][0] = A[i];
            }
            i++;
        }
        int[] res = new int[len];
        for (int[] a : arr) {
            res[a[1]] = a[0];
        }
        return res;
    }
}
