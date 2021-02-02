package problem700To800;

import java.util.*;

// 并查集，就是01-29题目的变形
public class a778swimInWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Union union = new Union(n * n);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                if (i > 0) {
                    list.add(new int[]{id - n, id, Math.max(grid[i - 1][j], grid[i][j])});
                }
                if (j > 0) {
                    list.add(new int[]{id - 1, id, Math.max(grid[i][j - 1], grid[i][j])});
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o[2]));
        for (int[] arr : list) {
            int fx = union.find(arr[0]);
            int fy = union.find(arr[1]);
            if (fx == fy) continue;
            union.union(fx, fy);
            int fs = union.find(0);
            int fe = union.find(n * n - 1);
            if (fs == fe) {
                return arr[2];
            }
        }
        return -1;
    }

    static class Union {
        int[] arr;
        int[] size;

        public Union(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int find(int m) {
            if (arr[m] != m) {
                arr[m] = find(arr[m]);
            }
            return arr[m];
        }

        public void union(int fx, int fy) {
            if (fx == fy) return;
            if (size[fx] < size[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            size[fx] += size[fy];
            arr[fy] = fx;
        }
    }
}
