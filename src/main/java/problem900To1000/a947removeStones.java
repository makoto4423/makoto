package problem900To1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 看题目以为是八皇后，没想到又是图。。。
// 并查集
@Deprecated
public class a947removeStones {

    public int removeStones(int[][] stones) {
        Union union = new Union();
        for (int[] st : stones) {
            // 能通过一维的并查集去找二维数组的连通分量，这里对横坐标取反码，
            // 由于st恒大于零，横坐标反码则恒小于零，这样就可以避免横坐标等于纵坐标时，找到同一个parent
            union.union(~st[0], st[1]);
        }
        return stones.length - union.count;
    }


    static class Union {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        public int find(int a) {
            if (!map.containsKey(a)) {
                map.put(a, a);
                count++;
            }

            if (map.get(a) != a) {
                map.put(a, find(map.get(a)));
            }
            return map.get(a);
        }

        public void union(int x, int y) {
            int findX = find(x);
            int findY = find(y);
            if (findX == findY) {
                return;
            }
            map.put(findX, findY);
            count--;
        }
    }
}
