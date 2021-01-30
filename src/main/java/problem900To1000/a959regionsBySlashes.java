package problem900To1000;

import java.util.LinkedList;
import java.util.Queue;

// 还是有并查集的解法，我仍旧是dfs
public class a959regionsBySlashes {
    int[] xGrid = {1, 0, -1, 0};
    int[] yGrid = {0, 1, 0, -1};

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] matrix = new int[4 * n][4 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '\\') {
                    matrix[4 * i][4 * j] = 1;
                    matrix[4 * i + 1][4 * j + 1] = 1;
                    matrix[4 * i + 2][4 * j + 2] = 1;
                    matrix[4 * i + 3][4 * j + 3] = 1;
                }
                if (ch == '/') {
                    matrix[4 * i][4 * j + 3] = 1;
                    matrix[4 * i + 1][4 * j + 2] = 1;
                    matrix[4 * i + 2][4 * j + 1] = 1;
                    matrix[4 * i + 3][4 * j] = 1;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < 4 * n; i++) {
            for (int j = 0; j < 4 * n; j++) {
                if (matrix[i][j] == 0) {
                    res++;
                    matrix[i][j] = 1;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] p = queue.poll();
                        for (int m = 0; m < 4; m++) {
                            int x = p[0] + xGrid[m], y = p[1] + yGrid[m];
                            if (x >= 0 && x < 4 * n && y >= 0 && y < 4 * n && matrix[x][y] == 0) {
                                matrix[x][y] = 1;
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
