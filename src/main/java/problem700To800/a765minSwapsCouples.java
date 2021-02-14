package problem700To800;

import java.util.Arrays;

// 怎么又是并查集啊。。。
@Deprecated
public class a765minSwapsCouples {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        Union union = new Union(n / 2);
        for (int i = 0; i < n; i = i + 2) {
            int fx = union.find(row[i] / 2);
            int fy = union.find(row[i + 1] / 2);
            if (fx != fy) {
                union.union(fx, fy);
            }
        }
        return union.cnt;
    }

    static class Union {
        int[] arr;
        int[] size;
        int cnt;

        public Union(int m) {
            arr = new int[m];
            size = new int[m];
            Arrays.fill(size, 1);
            for (int i = 0; i < m; i++) {
                arr[i] = i;
            }
            cnt = 0;
        }

        public int find(int m) {
            if (arr[m] != m) {
                arr[m] = find(arr[m]);
            }
            return arr[m];
        }

        public void union(int x, int y) {
            if (size[x] < size[y]) {
                int temp = y;
                y = x;
                x = temp;
            }
            arr[y] = x;
            size[x] += size[y];
            cnt++;
        }
    }
}
