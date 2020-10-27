package problem900To1000;

public class a980uniquePathsIII {
    int[][] grid;
    int xLen, yLen;
    int[] xGrid = {0, 1, -1, 0};
    int[] yGrid = {1, 0, 0, -1};
    int res;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.xLen = grid.length;
        this.yLen = grid[0].length;
        this.res = 0;
        boolean[][] visited = new boolean[xLen][yLen];
        int cnt = 0, x = -1, y = -1;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        recur(x, y, visited, cnt);
        return res;
    }

    public void recur(int x, int y, boolean[][] visited, int cnt) {
        for (int i = 0; i < 4; i++) {
            int m = x + xGrid[i], n = y + yGrid[i];
            if (m >= 0 && n >= 0 && m < xLen && n < yLen && !visited[m][n]) {
                if (grid[m][n] == 2 && cnt == 0) {
                    res++;
                } else if (grid[m][n] == 0) {
                    visited[m][n] = true;
                    recur(m, n, visited, cnt - 1);
                    visited[m][n] = false;
                }
            }
        }
    }
}
