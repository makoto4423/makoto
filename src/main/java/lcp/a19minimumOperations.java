package lcp;

@Deprecated
public class a19minimumOperations {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] f = new int[n][3];
        f[0][0] = leaves.charAt(0) == 'y' ? 1 : 0;
        f[0][1] = f[0][2] = f[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int isRed = leaves.charAt(i) == 'y' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'r' ? 1 : 0;
            f[i][0] = f[i - 1][0] + isRed;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isYellow;
            if (i > 1) {
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isRed;
            }
        }
        return f[n - 1][2];
    }
}
