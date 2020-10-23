package problem1200To1300;

public class a1267countServers {

    public int countServers(int[][] grid) {
        int xLen = grid.length;
        if (xLen == 0) return 0;
        int yLen = grid[0].length;
        int[] xVi = new int[xLen];
        int[] yVi = new int[yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 1) {
                    xVi[i]++;
                    yVi[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 1 && (xVi[i] > 1 || yVi[j] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }

}
