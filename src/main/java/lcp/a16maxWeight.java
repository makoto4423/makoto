package lcp;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目分上午&下午，但不能通过局部最大值来求全局最大值
 * 4层循环，不超时才怪。。。
 */
@Deprecated
public class a16maxWeight {
    public int maxWeight(int[][] edges, int[] value) {
        Map<Integer, Point> map = new HashMap<>();
        int len = value.length;
        for (int[] edge : edges) {
            Point a = map.getOrDefault(edge[0], new Point(edge[0]));
            Point b = map.getOrDefault(edge[1], new Point(edge[1]));
            a.set.add(b.i);
            b.set.add(a.i);
            map.put(a.i, a);
            map.put(b.i, b);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            Set<Integer> aSet = map.get(i).set;
            for (int m : aSet) {
                if (i == m) continue;
                Set<Integer> bSet = map.get(m).set;
                for (int n : bSet) {
                    if (n == m || n == i) continue;
                    Set<Integer> cSet = map.get(n).set;
                    if (cSet.contains(i)) {
                        for (int k : aSet) {
                            if (i == k) continue;
                            Set<Integer> dSet = map.get(k).set;
                            for (int p : dSet) {
                                if (p == k || p == i) continue;
                                Set<Integer> eSet = map.get(p).set;
                                if (eSet.contains(i)) {
                                    int val = value[i] + value[m] + value[n];
                                    if (k != m && k != n) {
                                        val += value[k];
                                    }
                                    if (p != m && p != n) {
                                        val += value[p];
                                    }
                                    max = Math.max(val, max);
                                }
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    static class Point {
        public Integer i;
        public Set<Integer> set;

        public Point(Integer i) {
            this.i = i;
            this.set = new HashSet<>();
        }
    }
}
