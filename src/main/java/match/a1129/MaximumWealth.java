package match.a1129;

public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        for (int[] acc : accounts) {
            int temp = 0;
            for (int i : acc) {
                temp += i;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
