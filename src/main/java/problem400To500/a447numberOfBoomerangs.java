package problem400To500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a447numberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        List<Map<Long, Integer>> list = new ArrayList<>();
        for (int[] ints : points) {
            Map<Long, Integer> map = new HashMap<>();
            for (int[] point : points) {
                long dis = (ints[0] - point[0]) * (ints[0] - point[0])
                        + (ints[1] - point[1]) * (ints[1] - point[1]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            list.add(map);
        }
        int res = 0;
        for (Map<Long, Integer> map : list) {
            for (int val : map.values()) {
                if (val > 1) {
                    res += val * (val - 1);
                }
            }
        }
        return res;
    }
}
