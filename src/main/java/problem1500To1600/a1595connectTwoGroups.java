package problem1500To1600;

import java.util.Arrays;
import java.util.List;

// 动态规划，状态压缩
@Deprecated
public class a1595connectTwoGroups {

    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size(), n = cost.get(0).size();
        int[][] costMatrix = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                for (int k = 0; k < n; k++) {
                    if ((j & (1 << k)) > 0) {
                        costMatrix[i][j] += cost.get(i).get(k);
                    }
                }
            }
        }
        int[][] dp = new int[m][1 << n];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));
        dp[0] = costMatrix[0];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < (1 << n); j++) {
                for (int k = 1; k < (1 << n); k++) {
                    dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][k] + costMatrix[i][j]);
                }
            }
        }
        return dp[m - 1][(1<<n)-1];
    }

//    int[] xGrid, yGrid;
//    int m, n, res = Integer.MAX_VALUE;
//    List<List<Integer>> cost;
//
//    public int connectTwoGroups(List<List<Integer>> cost) {
//        m = cost.size();
//        n = cost.get(0).size();
//        xGrid = new int[m];
//        yGrid = new int[n];
//        this.cost = cost;
//        recur(0, 0, 0);
//        return res;
//    }
//
//    public void recur(int i, int j, int val) {
//        if (i == m) {
//            int k = 0, p = 0;
//            for (int x : xGrid) {
//                k = x > 0 ? k + 1 : k;
//            }
//            for (int y : yGrid) {
//                p = y > 0 ? p + 1 : p;
//            }
//            if (k == m && p == n) {
//                res = Math.min(val, res);
//            }
//            return;
//        }
//        if (xGrid[i] < 2 || yGrid[j] < 2) {
//            xGrid[i]++;
//            yGrid[j]++;
//            int y = j == n - 1 ? 0 : j + 1;
//            int x = j == n - 1 ? i + 1 : i;
//            recur(x, y, val + cost.get(i).get(j));
//            xGrid[i]--;
//            yGrid[j]--;
//        }
//        int y = j == n - 1 ? 0 : j + 1;
//        int x = j == n - 1 ? i + 1 : i;
//        recur(x, y, val);
//    }
}
