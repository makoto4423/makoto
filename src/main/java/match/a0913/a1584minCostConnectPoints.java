package match.a0913;

import java.util.HashSet;
import java.util.Set;

public class a1584minCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] stat = new int[n][n];
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    stat[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                int[] a = points[j];
                stat[i][j] = Math.abs(a[0] - p[0]) + Math.abs(a[1] - p[1]);
            }
        }
        int[][] line = new int[n][2];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (stat[i][j] < min){
                    min = stat[i][j];
                    line[i][0] = min;
                    line[i][1] = j;
                }
            }
        }
        boolean[] visited = new boolean[n];
        int res = line[0][0],amount=1;
        visited[0] = true;
        while (amount != n){

        }
        return 1;
    }
}
