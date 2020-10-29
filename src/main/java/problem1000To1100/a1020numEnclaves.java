package problem1000To1100;

import java.util.LinkedList;
import java.util.Queue;

public class a1020numEnclaves {
    int xLen;
    int yLen;
    int[] xGrid = {0, 1, 0, -1};
    int[] yGrid = {1, 0, -1, 0};

    public int numEnclaves(int[][] A) {
        xLen = A.length;
        yLen = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < xLen; i++) {
            if (A[i][0] == 1) {
                queue.add(new int[]{i, 0});
                populate(queue, A);
            }
            if (A[i][yLen - 1] == 1) {
                queue.add(new int[]{i, yLen - 1});
                populate(queue, A);
            }
        }
        for (int j = 0; j < yLen; j++) {
            if (A[0][j] == 1) {
                queue.add(new int[]{0, j});
                populate(queue, A);
            }
            if (A[xLen - 1][j] == 1) {
                queue.add(new int[]{xLen - 1, j});
                populate(queue, A);
            }
        }
        int cnt = 0;
        for (int[] a : A) {
            for (int i : a) {
                if (i == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void populate(Queue<int[]> queue, int[][] A) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (A[pos[0]][pos[1]] == 1) {
                A[pos[0]][pos[1]] = 2;
                for (int k = 0; k < 4; k++) {
                    int x = pos[0] + xGrid[k], y = pos[1] + yGrid[k];
                    if (x >= 0 && y >= 0 && x < xLen && y < yLen) {
                        if (A[x][y] == 1) {
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }
}
