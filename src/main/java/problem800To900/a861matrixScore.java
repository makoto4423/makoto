package problem800To900;

@Deprecated
public class a861matrixScore {
    public int matrixScore(int[][] A) {
        int xLen = A.length;
        int yLen = A[0].length;
        int res = xLen * (1 << (yLen - 1));
        for (int j = 1; j < yLen; j++) {
            int temp = 0;
            for (int[] ints : A) {
                if (ints[0] == 1) {
                    temp += ints[j];
                } else {
                    temp += (1 - ints[j]);
                }
            }
            int k = Math.max(temp, xLen - temp);
            res += k * (1 << (yLen - j - 1));
        }
        return res;
    }
}
