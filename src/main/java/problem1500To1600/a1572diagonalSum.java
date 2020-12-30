package problem1500To1600;

public class a1572diagonalSum {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int x = mat.length;
        for (int i = 0; i < x; i++) {
            res += mat[i][i];
            res += mat[i][x - i - 1];
        }
        if (x % 2 == 1) {
            res -= mat[x / 2][x / 2];
        }
        return res;
    }
}
