package problem700To800;

public class a766isToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int xLen = matrix.length;
        int yLen = matrix[0].length;
        for (int i = 0; i < xLen; i++) {
            for (int j = 1; i + j < xLen && j < yLen; j++) {
                if (matrix[i][0] != matrix[i + j][j]) return false;
            }
        }
        for (int i = 0; i < yLen; i++) {
            for (int j = 1; j < xLen && i + j < yLen; j++) {
                if (matrix[0][i] != matrix[j][i + j]) return false;
            }
        }
        return true;
    }
}
