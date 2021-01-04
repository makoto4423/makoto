package problem1200To1300;

import java.util.*;

public class a1218longestSubsequence {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            int val = 1;
            if (map.containsKey(j - difference)) {
                val += map.get(j - difference);
            }
            map.put(j, Math.max(val, map.getOrDefault(j, 1)));
        }
        int res = 0;
        for (int i : map.values()) {
            res = Math.max(i, res);
        }
        return res;
    }
}
