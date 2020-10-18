package match.a1011;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class a5536maximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] stat = new int[n];
        for (int[] road : roads) {
            Set<Integer> set = map.getOrDefault(Math.min(road[0], road[1]), new HashSet<>());
            set.add(Math.max(road[0], road[1]));
            map.put(Math.min(road[0], road[1]), set);
            stat[road[0]]++;
            stat[road[1]]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = stat[i] + stat[j];
                if (map.getOrDefault(i, new HashSet<>()).contains(j)) {
                    temp--;
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }
}
