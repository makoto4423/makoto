package problem1To100;

public class a74searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        while (i != m - 1 || j != n - 1) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) return false;
            if (i != m - 1) {
                int down = matrix[i + 1][j];
                if (down <= target || j == n - 1) {
                    i++;
                } else {
                    j++;
                }
            } else {
                j++;
            }
        }
        return matrix[i][j] == target;
    }
}
