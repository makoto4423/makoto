package problem1To100;

public class a36isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] line = new boolean[9][9];
        boolean[][][] block = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                if (row[i][num] || line[j][num] || block[i / 3][j / 3][num]) {
                    return false;
                }
                row[i][num] = line[j][num] = block[i / 3][j / 3][num] = true;
            }
        }
        return true;
    }
}
