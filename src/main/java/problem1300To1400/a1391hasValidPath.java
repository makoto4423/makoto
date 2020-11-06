package problem1300To1400;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a1391hasValidPath {

    int[][] one = {{}, {0, -1}, {1, 0}, {0, -1}, {1, 0}, {-1, 0}, {0, 1}};
    int[][] two = {{}, {0, 1}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    int xLen, yLen;
    int[][] grid;

    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        xLen = grid.length;
        yLen = grid[0].length;
        boolean[][] visited = new boolean[xLen][yLen];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            if (x == xLen - 1 && y == yLen - 1) return true;
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            List<int[]> access = access(x,y);
            for(int[] p : access){
                if(!visited[p[0]][p[1]]){
                    boolean b = false;
                    List<int[]> re = access(p[0],p[1]);
                    for(int[] r : re){
                        if (r[0] == x && r[1] == y) {
                            b = true;
                            break;
                        }
                    }
                    if(b){
                        queue.add(p);
                    }
                }
            }
        }
        return false;
    }

    private List<int[]> access(int x, int y) {
        List<int[]> list = new ArrayList<>();
        int m = x + one[grid[x][y]][0], n = y + one[grid[x][y]][1];
        if (m >= 0 && m < xLen && n >= 0 && n < yLen) {
            list.add(new int[]{m, n});
        }
        m = x + two[grid[x][y]][0];
        n = y + two[grid[x][y]][1];
        if (m >= 0 && m < xLen && n >= 0 && n < yLen) {
            list.add(new int[]{m, n});
        }
        return list;
    }
}
