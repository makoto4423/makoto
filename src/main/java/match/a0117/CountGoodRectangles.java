package match.a0117;

public class CountGoodRectangles {
    public int countGoodRectangles(int[][] rectangles) {
        int max = -1, cnt = 0;
        for (int[] re : rectangles) {
            if (max < Math.min(re[0], re[1])) {
                max = Math.min(re[0], re[1]);
                cnt = 1;
            } else if (max == Math.min(re[0], re[1])) {
                cnt++;
            }
        }
        return cnt;
    }
}
