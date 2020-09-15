package problem1To100;

import java.util.ArrayList;
import java.util.List;

// 不是自己写的，其实答案有更优的解法，不过暂时没空看，记下来吧
@Deprecated
public class a37solveSudoku {
    boolean[][] line = new boolean[9][9];
    boolean[][] row = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    boolean valid = false;
    List<int[]> empty = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    empty.add(new int[]{i, j});
                } else {
                    int v = board[i][j] - '0' - 1;
                    line[i][v] = true;
                    row[v][j] = true;
                    block[i / 3][j / 3][v] = true;
                }
            }
        }
        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == empty.size()) {
            valid = true;
            return;
        }
        int i = empty.get(pos)[0], j = empty.get(pos)[1];
        for (int m = 0; m < 9 && !valid; m++) {
            if (!line[i][m] && !row[m][j] && !block[i / 3][j / 3][m]) {
                line[i][m] = true;
                row[m][j] = true;
                block[i / 3][j / 3][m] = true;
                board[i][j] = (char) (m + '0' + 1);
                dfs(board, pos + 1);
                line[i][m] = false;
                row[m][j] = false;
                block[i / 3][j / 3][m] = false;
            }
        }
    }
}
