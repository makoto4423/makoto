package interview1To100;

public class a47maxValue {
    public int maxValue(int[][] grid) {
        int xLen = grid.length;
        if (xLen == 0) return -1;
        int yLen = grid[0].length;
        int[][] matrix = new int[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (i == 0 && j == 0) {
                    matrix[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    matrix[i][j] = grid[i][j] + matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] = grid[i][j] + matrix[i - 1][j];
                } else {
                    matrix[i][j] = grid[i][j] + Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[xLen-1][yLen-1];
    }
}
