package lcp;

import java.util.*;

// 有动态规划版
public class a07numWays {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] re : relation) {
            map.computeIfAbsent(re[0], key -> new ArrayList<>()).add(re[1]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (k != 0 && !list.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i : list) {
                temp.addAll(map.getOrDefault(i, Collections.emptyList()));
            }
            list = temp;
            k--;
        }
        if (k == 0) {
            return (int) list.stream().filter(i -> i == n - 1).count();
        }
        return 0;
    }
}
