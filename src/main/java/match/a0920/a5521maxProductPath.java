package match.a0920;

@Deprecated
/**
 * a152maxProduct
 */
public class a5521maxProductPath {
    public int maxProductPath(int[][] grid) {
        int xLen = grid.length;
        int yLen = grid[0].length;
        long[][][] arr = new long[xLen][yLen][2];
        arr[0][0][0] = grid[0][0];
        arr[0][0][1] = grid[0][0];
        for (int i = 1; i < xLen; i++) {
            arr[i][0][0] = arr[i - 1][0][0] * grid[i][0];
            arr[i][0][1] = arr[i - 1][0][1] * grid[i][0];
        }
        for (int i = 1; i < yLen; i++) {
            arr[0][i][0] = arr[0][i - 1][0] * grid[0][i];
            arr[0][i][1] = arr[0][i - 1][1] * grid[0][i];
        }
        for (int i = 1; i < xLen; i++) {
            for (int j = 1; j < yLen; j++) {
                if (grid[i][j] > 0) {
                    arr[i][j][0] = Math.min(arr[i - 1][j][0] * grid[i][j], arr[i][j - 1][0] * grid[i][j]);
                    arr[i][j][1] = Math.max(arr[i - 1][j][1] * grid[i][j], arr[i][j - 1][1] * grid[i][j]);
                } else if (grid[i][j] < 0) {
                    arr[i][j][0] = Math.min(arr[i - 1][j][1] * grid[i][j], arr[i][j - 1][1] * grid[i][j]);
                    arr[i][j][1] = Math.max(arr[i - 1][j][0] * grid[i][j], arr[i][j - 1][0] * grid[i][j]);
                }
            }
        }
        if (arr[xLen - 1][yLen - 1][1] < 0) {
            return -1;
        }
        return (int) (arr[xLen - 1][yLen - 1][1] % 1000000007);
    }
}
