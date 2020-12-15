package problem400To500;

import java.util.*;

// 这是hard？？？
public class a403canCross {
    public boolean canCross(int[] stones) {
        int len = stones.length;
        List<Set<Integer>> dp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            dp.add(new HashSet<>());
            map.put(stones[i], i);
        }
        if (!map.containsKey(stones[0] + 1)) return false;
        dp.get(1).add(1);
        for (int i = 1; i < len; i++) {
            Set<Integer> set = dp.get(i);
            for (int k : set) {
                int p = stones[i];
                if (map.containsKey(p + k)) {
                    dp.get(map.get(p + k)).add(k);
                }
                if (map.containsKey(p + k + 1)) {
                    dp.get(map.get(p + k + 1)).add(k + 1);
                }
                if (k - 1 != 0 && map.containsKey(p + k - 1)) {
                    dp.get(map.get(p + k - 1)).add(k - 1);
                }
            }
            if (dp.get(len - 1).size() != 0) return true;
        }
        return false;
    }
}
