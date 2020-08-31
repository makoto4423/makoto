package problem800To900;

import java.util.*;

public class a827largestIsland {
    int xLen;
    int yLen;
    int[] xGrid = {1, 0, -1, 0};
    int[] yGrid = {0, 1, 0, -1};
    int[][] grid;
    int[][] colors;

    public int largestIsland(int[][] grid) {
        xLen = grid.length;
        yLen = grid[0].length;
        this.grid = grid;
        colors = new int[xLen][yLen];
        calculate();
        int res = 0;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 0) {
                    int temp = 1;
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int m = 0; m < 4; m++) {
                        int x = i + xGrid[m], y = j + yGrid[m];
                        if (x >= 0 && x < xLen && y >= 0 && y < yLen) {
                            if (map.containsKey(colors[x][y])) {
                                int value = map.get(colors[x][y]);
                                value = Math.max(value, grid[x][y]);
                                map.put(colors[x][y], value);
                            } else {
                                map.put(colors[x][y], grid[x][y]);
                            }
                        }
                    }
                    for (int value : map.values()) {
                        temp += value;
                    }
                    res = Math.max(temp, res);
                } else {
                    res = Math.max(grid[i][j], res);
                }
            }
        }
        return res;
    }

    public void calculate() {
        int color = 1;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                if (grid[i][j] == 1) {
                    Queue<Point> queue = new LinkedList<>();
                    Set<Point> set = new HashSet<>();
                    boolean[][] visited = new boolean[xLen][yLen];
                    int area = 0;
                    queue.add(new Point(i, j));
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        if (visited[p.x][p.y]) {
                            continue;
                        }
                        set.add(p);
                        visited[p.x][p.y] = true;
                        area++;
                        for (int m = 0; m < 4; m++) {
                            int x = p.x + xGrid[m], y = p.y + yGrid[m];
                            if (x >= 0 && x < xLen && y >= 0 && y < yLen && !visited[x][y] && grid[x][y] == 1) {
                                queue.add(new Point(x, y));
                            }
                        }
                    }
                    for (Point p : set) {
                        grid[p.x][p.y] = area;
                        colors[p.x][p.y] = color;
                    }
                    color++;
                }
            }
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
