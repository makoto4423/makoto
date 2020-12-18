package problem800To900;

public class a835largestOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int xLen = img1.length;
        int yLen = img1[0].length;
        int res = 0;
        for (int i = -xLen; i < xLen; i++) {
            for (int j = -yLen; j < yLen; j++) {
                res = Math.max(res, calculate(img1, img2, i, j));
            }
        }
        return res;
    }

    public int calculate(int[][] img1, int[][] img2, int x, int y) {
        int xLen = img1.length;
        int yLen = img1[0].length;
        int[] start1 = new int[2];
        start1[0] = x >= 0 ? 0 : -1 * x;
        start1[1] = y >= 0 ? 0 : -1 * y;
        int[] start2 = new int[2];
        start2[0] = Math.max(x, 0);
        start2[1] = Math.max(y, 0);
        int[] end2 = new int[2];
        end2[0] = Math.min(x + xLen, xLen);
        end2[1] = Math.min(y + yLen, yLen);
        int res = 0;
        for (int i = start2[0], m = start1[0]; i < end2[0]; i++, m++) {
            for (int j = start2[1], n = start1[1]; j < end2[1]; j++, n++) {
                if (img2[i][j] == 1 && img1[m][n] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
