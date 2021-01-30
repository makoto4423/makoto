package problem1600To1700;


import java.util.*;

// 并查集（此题用并查集），二分查找，Dijkstra
@Deprecated
public class a1631minimumEffortPath {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // heights的行号加列生成唯一的标志
                int id = i * n + j;
                if (i > 0) {
                    edges.add(new int[]{id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Union union = new Union(m * n);
        edges.sort(Comparator.comparingInt(a -> a[2]));
        for (int[] edge : edges) {
            int fx = union.find(edge[0]), fy = union.find(edge[1]);
            if (fx == fy) continue;
            union.union(fx, fy);
            int start = union.find(0), end = union.find(m * n - 1);
            // 如果左上节点和右下节点连通了，则当前边即为答案
            if (start == end) {
                return edge[2];
            }
        }
        // 只有一个节点的时候
        return 0;
    }

    static class Union {
        int[] arr;
        int[] size;

        public Union(int n) {
            arr = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }

        public int find(int a) {
            if (arr[a] != a) {
                arr[a] = find(arr[a]);
            }
            return arr[a];
        }

        public void union(int x, int y) {
            if (size[x] < size[y]) {
                int temp = y;
                y = x;
                x = temp;
            }
            arr[y] = x;
            size[x] += size[y];
        }
    }
}
