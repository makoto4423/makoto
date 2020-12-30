package problem400To500;

import java.util.Arrays;

public class a455findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, res = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                res++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}
