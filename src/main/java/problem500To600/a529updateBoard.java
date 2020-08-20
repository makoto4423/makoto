package problem500To600;

import java.util.LinkedList;
import java.util.Queue;

public class a529updateBoard {
    int[] gridX = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] gridY = {-1, -1, -1, 0, 0, 1, 1, 1};
    int xLen, yLen;

    public char[][] updateBoard(char[][] board, int[] click) {
        xLen = board.length;
        yLen = board[0].length;
        int[][] grid = new int[xLen][yLen];
        // 需要加visited进行剪枝，否则会timeout
        boolean[][] visited = new boolean[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (board[i][j] == 'M') {
                    for (int m = 0; m < 8; m++) {
                        int newX = i + gridX[m], newY = j + gridY[m];
                        if (newX >= 0 && newX < xLen && newY >= 0 && newY < yLen) {
                            grid[newX][newY]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < click.length; i = i + 2) {
            Point point = new Point(click[i], click[i + 1]);
            if (board[point.x][point.y] == 'M') {
                board[point.x][point.y] = 'X';
                return board;
            }
            if (board[point.x][point.y] == 'E') {
                Queue<Point> queue = new LinkedList<>();
                queue.add(point);
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    if (grid[p.x][p.y] != 0) {
                        board[p.x][p.y] = (char) ('0' + grid[p.x][p.y]);
                    } else {
                        board[p.x][p.y] = 'B';
                        for (int m = 0; m < 8; m++) {
                            int newX = p.x + gridX[m], newY = p.y + gridY[m];
                            if (newX >= 0 && newX < xLen && newY >= 0 && newY < yLen
                                    && board[newX][newY] == 'E' && !visited[newX][newY]) {
                                visited[newX][newY] = true;
                                queue.add(new Point(newX, newY));
                            }
                        }
                    }
                }
            }
        }
        return board;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
