package problem400To500;

public class a463islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int xLen = grid.length;
        if (xLen == 0) return res;
        int yLen = grid[0].length;
        int[] xGrid = {1, 0, 0, -1};
        int[] yGrid = {0, 1, -1, 0};
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        res++;
                    }
                    if (i == xLen - 1) {
                        res++;
                    }
                    if (j == 0) {
                        res++;
                    }
                    if (j == yLen - 1) {
                        res++;
                    }
                } else {
                    for (int k = 0; k < 4; k++) {
                        int m = i + xGrid[k], n = j + yGrid[k];
                        if (m >= 0 && m < xLen && n >= 0 && n < yLen && grid[m][n] == 1) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
