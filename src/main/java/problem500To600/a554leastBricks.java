package problem500To600;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a554leastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.get(0).stream().mapToInt(Integer::intValue).sum();
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int l = 0;
            for (int val : list) {
                l += val;
                if (l != n) {
                    map.put(l, map.getOrDefault(l, 0) + 1);
                }
            }
        }
        if (map.isEmpty()) return wall.size();
        int v = map.values().stream().mapToInt(Integer::intValue).max().orElse(-1);
        return wall.size() - v;
    }
}
