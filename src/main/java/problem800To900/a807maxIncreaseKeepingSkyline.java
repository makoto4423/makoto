package problem800To900;

import java.util.Arrays;

public class a807maxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] xGrid = new int[n];
        int[] yGrid = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                xGrid[i] = Math.max(xGrid[i], grid[i][j]);
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                yGrid[j] = Math.max(yGrid[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(xGrid[i], yGrid[j]) - grid[i][j];
            }
        }
        return res;
    }
}
