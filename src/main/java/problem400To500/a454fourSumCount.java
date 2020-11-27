package problem400To500;

import java.util.HashMap;
import java.util.Map;

public class a454fourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : A) {
            for (int k : B) {
                map.put(j + k, map.getOrDefault(j + k, 0) + 1);
            }
        }
        int res = 0;
        for (int i : C) {
            for (int j : D) {
                res += map.getOrDefault(-(i + j), 0);
            }
        }
        return res;
    }
}
