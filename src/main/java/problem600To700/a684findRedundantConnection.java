package problem600To700;

// 又是并查集。。。
public class a684findRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        Union union = new Union(len);
        for (int[] edge : edges) {
            int m = edge[0], n = edge[1];
            if (union.find(m) == union.find(n)) {
                return edge;
            }
            union.add(m, n);
        }
        return new int[]{};
    }

    static class Union {
        int[] arr;

        public Union(int n) {
            this.arr = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                arr[i] = i;
            }
        }

        public int find(int n) {
            if (arr[n] != n) {
                arr[n] = find(arr[n]);
            }
            return arr[n];
        }

        public void add(int m, int n) {
            arr[find(n)] = find(m);
        }
    }

}
