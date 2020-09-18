package problem600To700;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在入度为2的点，若该点出度为0，直接删除最后一次进入该节点的边；
 * 若出度不为0，找寻下一个节点，当遍历回此节点表明存在环，删除该边，若返回null，删除最后一次进入该节点的边
 * 若不存在，则表明整个数组构成一个环，删除最有一次出现的边
 */
// 逻辑是出来了，但是苦于不知道怎么判断环
@Deprecated
public class a685findRedundantDirectedConnection {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        Union union = new Union(n + 1);
        int[] parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        int conflict = -1, circle = -1;
        for (int i = 0; i < edges.length; i++) {
            int j = edges[i][0], k = edges[i][1];
            // 首次进来，parent[k]指向自己，在后面的else分支后值改变不指向k，
            // 第二次判断，表明k已经被指向过一次
            if (parent[k] != k) {
                conflict = i;
            } else {
                parent[k] = j;
                // 当j,k不联通时，是否存在相同的祖先，
                // 若存在，同时由于此时k不是入度为2的，表明该边出现后回构成环
                if (union.find(j) == union.find(k)) {
                    circle = i;
                } else {
                    union.union(k,j);
                }
            }
        }
        if (conflict < 0) {
            // 不存在入度为2的，就只能是存在环的情况
            return edges[circle];
        } else {
            int[] conflictEdge = edges[conflict];
            if (circle >= 0) {
                // 存在环和入度为2的情况
                // 就是因为这里，所以parent不可以取union的arr,union的arr是树的实时状态,
                // 而parent是个值·类似·于相反edges(a->b 变成 b->a)的拷贝
                return new int[]{parent[conflictEdge[1]], conflictEdge[1]};
            } else {
                return conflictEdge;
            }
        }
    }

    static class Union {
        int[] arr;

        public Union(int n) {
            this.arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
        }

        public void union(int i, int j) {
            arr[find(i)] = find(j);
        }

        public int find(int i) {
            if (arr[i] != i) {
                arr[i] = find(arr[i]);
            }
            return arr[i];
        }
    }


//    int[] res;
//
//    public int[] findRedundantDirectedConnection(int[][] edges) {
//        res = null;
//        int n = edges.length;
//        int[] inDegree = new int[n + 1];
//        int[] outDegree = new int[n+1];
//        Set<Integer>[] stat = new HashSet[n + 1];
//        for (int[] edge : edges) {
//            Set<Integer> set = stat[edge[0]];
//            if (set == null) {
//                set = new HashSet<>();
//            }
//            set.add(edge[1]);
//            inDegree[edge[1]]++;
//            outDegree[edge[0]]++;
//            stat[edge[0]] = set;
//        }
//        int root = -1;
//        for (int i = 1; i < n + 1; i++) {
//            if (inDegree[i] == 2) {
//                root = i;
//                break;
//            }
//        }
//        if (root == -1) {
//            for (int i = 1; i < n + 1; i++) {
//                if (outDegree[i] == 2) {
//                    root = i;
//                    break;
//                }
//            }
//            return edges[n - 1];
//        }
//        int node = root;
//        recur(node, root, stat);
//        if (res != null) {
//            return res;
//        }
//        for (int i = n - 1; i >= 0; i--) {
//            int[] edge = edges[i];
//            if (edge[1] == root) {
//                return edge;
//            }
//        }
//        return null;
//    }
//
//    public boolean recur(int node, int target, Set<Integer>[] stat) {
//        Set<Integer> set = stat[node];
//        if (set == null) {
//            return false;
//        }
//        for (Integer i : set) {
//            if (i == target) {
//                res = new int[]{node, target};
//                return true;
//            }
//        }
//        for (Integer i : set) {
//            if (recur(i, target, stat)) {
//                break;
//            }
//        }
//        return false;
//    }
}
