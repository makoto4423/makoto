package problem1To100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 参考数独
public class a51solveNQueens {
    boolean[] row, upLine, downLine;
    String[][] res;
    List<List<String>> ans;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
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
        return ans;
    }

    public void recur(int depth) {
        if (depth == n) {
            List<String> temp = new ArrayList<>();
            for(String[] ss : res){
                StringBuilder sb = new StringBuilder();
                for(String s : ss){
                    sb.append(s);
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return ;
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
