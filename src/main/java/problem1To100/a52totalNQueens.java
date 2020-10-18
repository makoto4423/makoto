package problem1To100;

import java.util.ArrayList;
import java.util.List;

public class a52totalNQueens {
    boolean[] row, upLine, downLine;
    String[][] res;
    List<List<String>> ans;
    int n;
    int aaa;

    public int totalNQueens(int n) {
        this.n = n;
        this.aaa = 0;
        row = new boolean[n];
        upLine = new boolean[2 * n - 1];
        downLine = new boolean[2 * n - 1];
        res = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = ".";
            }
        }
        ans = new ArrayList<>();
        recur(0);
        return aaa;
    }


    public void recur(int depth) {
        if (depth == n) {
            this.aaa++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!row[i] && !upLine[depth + i] && !downLine[n-1 - depth + i]) {
                row[i] = upLine[depth + i] = downLine[n-1 - depth + i] = true;
                res[i][depth] = "Q";
                recur(depth+1);
                res[i][depth] = ".";
                row[i] = upLine[depth + i] = downLine[n-1 - depth + i] = false;
            }
        }
    }
}
