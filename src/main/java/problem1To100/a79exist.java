package problem1To100;

public class a79exist {
    int[] xGrid = {1, 0, -1, 0};
    int[] yGrid = {0, 1, 0, -1};
    int xLen;
    int yLen;
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        xLen = board.length;
        if (xLen == 0) return false;
        yLen = board[0].length;
        if (yLen == 0) return false;
        this.board = board;
        this.word = word;
        boolean[][] visited = new boolean[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(recur(i,j,visited,1)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean recur(int x, int y, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        for (int m = 0; m < 4; m++) {
            int i = x + xGrid[m], j = y + yGrid[m];
            if (i >= 0 && j >= 0 && i < xLen && j < yLen
                    && !visited[i][j]
                    && board[i][j] == word.charAt(index)) {
                visited[i][j] = true;
                if (recur(i, j, visited, index + 1)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }
}
