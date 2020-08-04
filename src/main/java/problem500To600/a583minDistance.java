package problem500To600;

// 太久没认真写过了，脑子都转不动了。。。
@Deprecated
public class a583minDistance {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        return word1.length() + word2.length() - 2 * lcs(word1, word2, word1.length() - 1, word2.length() - 1, memo);
    }

    public int lcs(String a, String b, int m, int n, int[][] memo) {
        if (m < 0 || n < 0) return 0;
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        if (a.charAt(m) == b.charAt(n)) {
            memo[m][n] = 1 + lcs(a, b, m - 1, n - 1, memo);
        } else {
            memo[m][n] = Math.max(lcs(a, b, m - 1, n, memo), lcs(a, b, m, n - 1, memo));
        }
        return memo[m][n];
    }
}
