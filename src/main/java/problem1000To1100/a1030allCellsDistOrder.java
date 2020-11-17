package problem1000To1100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a1030allCellsDistOrder {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[R][C];
        int[] xGrid = {1, -1, 0, 0};
        int[] yGrid = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r0, c0});
        while (!queue.isEmpty()) {
            int[] i = queue.poll();
            int x = i[0], y = i[1];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            list.add(i);
            for (int k = 0; k < 4; k++) {
                int m = x + xGrid[k], n = y + yGrid[k];
                if (m >= 0 && m < R && n >= 0 && n < C && !visited[m][n]) {
                    queue.add(new int[]{m, n});
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
