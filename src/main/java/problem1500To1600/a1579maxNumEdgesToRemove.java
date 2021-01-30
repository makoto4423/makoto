package problem1500To1600;

// 怕了怕了，以后在leetcode看见图，第一个dfs，第二个并查集，第三个拓扑
// 这题是并查集
@Deprecated
public class a1579maxNumEdgesToRemove {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Union alice = new Union(n);
        Union bob = new Union(n);
        for (int[] ed : edges) {
            ed[2] = ed[2] - 1;
            ed[1] = ed[1] - 1;
        }
        int res = 0;
        for (int[] ed : edges) {
            if (ed[0] == 3) {
                int fx = alice.find(ed[1]);
                int fy = alice.find(ed[2]);
                if (fx == fy) {
                    res++;
                } else {
                    alice.union(fx, fy);
                    bob.union(fx, fy);
                }
            }
        }
        for (int[] ed : edges) {
            if (ed[0] == 1) {
                int fx = alice.find(ed[1]);
                int fy = alice.find(ed[2]);
                if (fx == fy) {
                    res++;
                } else {
                    alice.union(fx, fy);
                }
            }
        }
        for (int[] ed : edges) {
            if (ed[0] == 2) {
                int fx = bob.find(ed[1]);
                int fy = bob.find(ed[2]);
                if (fx == fy) {
                    res++;
                } else {
                    bob.union(fx, fy);
                }
            }
        }
        if (alice.cnt != 1 || bob.cnt != 1) {
            return -1;
        }
        return res;
    }

    static class Union {
        int[] arr;
        int cnt;

        public Union(int n) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            cnt = n;
        }

        public int find(int a) {
            if (arr[a] != a) {
                arr[a] = find(arr[a]);
            }
            return arr[a];
        }

        public void union(int x, int y) {
            arr[x] = y;
            cnt--;
        }
    }
}
