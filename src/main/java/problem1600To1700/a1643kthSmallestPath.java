package problem1600To1700;

// 动态规划
@Deprecated
public class a1643kthSmallestPath {
    public String kthSmallestPath(int[] destination, int k) {
        int h = destination[1], v = destination[0];
        int[][] dp = new int[h + v][h];
        dp[0][0] = 1;
        for (int i = 1; i < h + v; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i && j < h; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (h > 0 && v > 0) {
            int low = dp[h + v - 1][h - 1];
            if (low < k) {
                sb.append("V");
                v--;
                k -= low;
            } else {
                sb.append("H");
                h--;
            }
        }
        if (h == 0) {
            for (int i = 0; i < v; i++) {
                sb.append("V");
            }
        } else {
            for (int i = 0; i < h; i++) {
                sb.append("H");
            }
        }
        return sb.toString();
    }
}
