package problem1To100;

public class a59generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int t = 1, x = 0, y = 0, cir = 0;
        while (cir != n / 2) {
            for (; y < n - cir; y++) {
                res[x][y] = t;
                t++;
            }
            y--;
            x++;
            for (; x < n - cir; x++) {
                res[x][y] = t;
                t++;
            }
            x--;
            y--;
            for (; y >= cir; y--) {
                res[x][y] = t;
                t++;
            }
            y++;
            x--;
            for (; x >= cir + 1; x--) {
                res[x][y] = t;
                t++;
            }
            x++;
            y++;
            cir++;
        }
        if (n % 2 == 1) {
            res[x][y] = t;
        }
        return res;
    }
}
