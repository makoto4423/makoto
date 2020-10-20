package match.a1018;

import java.util.Arrays;

@Deprecated
public class a1626bestTeamScore {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = arr[i][1];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[j] + arr[i][1], dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
