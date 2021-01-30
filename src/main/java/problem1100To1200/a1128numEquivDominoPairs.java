package problem1100To1200;

import java.util.Arrays;

public class a1128numEquivDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] d : dominoes) {
            if (d[0] > d[1]) {
                d[0] += d[1];
                d[1] = d[0] - d[1];
                d[0] -= d[1];
            }
        }
        Arrays.sort(dominoes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int res = 0;
        for (int i = 1; i < dominoes.length; i++) {
            if (dominoes[i][0] == dominoes[i - 1][0] && dominoes[i][1] == dominoes[i - 1][1]) {
                int j = i + 1;
                for (; j < dominoes.length; j++) {
                    if (dominoes[i][0] != dominoes[j][0] || dominoes[i][1] != dominoes[j][1]) {
                        break;
                    }
                }
                res += (j - i + 1) * (j - i) / 2;
                j--;
                i = j;
            }
        }
        return res;
    }

}
