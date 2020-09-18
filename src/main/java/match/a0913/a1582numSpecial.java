package match.a0913;

// 当时还以为暴力会超时，写了半天放弃，不过现在这种写法的确快多了
@Deprecated
public class a1582numSpecial {
    public int numSpecial(int[][] mat) {
        int xLen = mat.length;
        int yLen = mat[0].length;
        int[] row = new int[xLen];
        int[] line = new int[yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    line[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && line[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
