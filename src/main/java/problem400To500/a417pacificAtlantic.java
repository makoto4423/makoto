package problem400To500;

import java.util.*;

public class a417pacificAtlantic {
    int[] xGrid = {1, 0, -1, 0};
    int[] yGrid = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int xLen = matrix.length;
        if (xLen == 0) return Collections.emptyList();
        int yLen = matrix[0].length;
        if (yLen == 0) return Collections.emptyList();
        if (xLen == 1 && yLen == 1) return Collections.singletonList(Arrays.asList(0, 0));
        char[][] land = new char[xLen][yLen];
        boolean[][] visited = new boolean[xLen][yLen];
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < xLen; i++) {
            queue.add(Arrays.asList(i, 0));
            visited[i][0] = true;
            land[i][0] = 't';
        }
        for (int i = 0; i < yLen; i++) {
            queue.add(Arrays.asList(0, i));
            visited[0][i] = true;
            land[0][i] = 't';
        }
        while (!queue.isEmpty()) {
            List<Integer> pos = queue.poll();
            int x = pos.get(0), y = pos.get(1);
            for (int i = 0; i < 4; i++) {
                int m = x + xGrid[i], n = y + yGrid[i];
                if (m >= 0 && m < xLen && n >= 0 && n < yLen &&
                        !visited[m][n] && matrix[x][y] <= matrix[m][n]) {
                    queue.add(Arrays.asList(m, n));
                    visited[m][n] = true;
                    land[m][n] = 't';
                }
            }
        }
        visited = new boolean[xLen][yLen];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < xLen - 1; i++) {
            queue.add(Arrays.asList(i, yLen - 1));
            visited[i][yLen - 1] = true;
            if (land[i][yLen - 1] == 't') {
                res.add(Arrays.asList(i, yLen - 1));
            }
        }
        for (int i = 0; i < yLen - 1; i++) {
            queue.add(Arrays.asList(xLen - 1, i));
            visited[xLen - 1][i] = true;
            if (land[xLen - 1][i] == 't') {
                res.add(Arrays.asList(xLen - 1, i));
            }
        }
        queue.add(Arrays.asList(xLen - 1, yLen - 1));
        visited[xLen - 1][yLen - 1] = true;
        if (land[xLen - 1][yLen - 1] == 't') {
            res.add(Arrays.asList(xLen - 1, yLen - 1));
        }
        while (!queue.isEmpty()) {
            List<Integer> pos = queue.poll();
            int x = pos.get(0), y = pos.get(1);
            for (int i = 0; i < 4; i++) {
                int m = x + xGrid[i], n = y + yGrid[i];
                if (m >= 0 && n >= 0 && m < xLen && n < yLen
                        && !visited[m][n] && matrix[x][y] <= matrix[m][n]) {
                    visited[m][n] = true;
                    queue.add(Arrays.asList(m, n));
                    if (land[m][n] == 't') {
                        res.add(Arrays.asList(m, n));
                    }
                }
            }
        }
        return res;
    }
}
