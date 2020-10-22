package problem1To100;

public class a73setZeroes {
    public void setZeroes(int[][] matrix) {
        int xLen = matrix.length;
        if (xLen == 0) return;
        int yLen = matrix[0].length;
        boolean[] xVi = new boolean[xLen];
        boolean[] yVi = new boolean[yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (matrix[i][j] == 0) {
                    xVi[i] = true;
                    yVi[j] = true;
                }
            }
        }
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if(xVi[i] || yVi[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
