package problem1000To1100;

import java.util.Arrays;
import java.util.Comparator;

public class a1048longestStrChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int len = words.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String a = words[i], b = words[j];
                if (a.length() - b.length() > 1) break;
                if (a.length() - b.length() == 1) {
                    int m = 0, n = 0;
                    while (m < a.length() && n < b.length()) {
                        if (a.charAt(m) == b.charAt(n)) {
                            m++;
                            n++;
                        } else {
                            m++;
                        }
                    }
                    if (n == b.length()) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return Arrays.stream(dp).max().orElse(-1);
    }
}
