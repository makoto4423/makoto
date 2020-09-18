package match.a0913;

// 一生之敌之一：懒癌
public class a1583unhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] stat = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] pre = preferences[i];
            int point = n - 1;
            for (int k : pre) {
                stat[i][k] = point;
                point--;
            }
        }
        int[] pa = new int[n];
        for (int[] p : pairs) {
            pa[p[0]] = p[1];
            pa[p[1]] = p[0];
        }
        int res = 0;
        for (int i = 0; i < pa.length; i++) {
            int partner = pa[i];
            int[] st = stat[i];
            int paSco = st[partner];
            for (int j = 0; j < st.length; j++) {
                if (j == i || j == partner) continue;
                int tempSco = stat[i][j];
                if (tempSco > paSco) {
                    int enemy = pa[j];
                    if (stat[j][i] > stat[j][enemy]) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
