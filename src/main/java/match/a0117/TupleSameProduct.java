package match.a0117;

import java.util.*;

public class TupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer k = map.computeIfAbsent(nums[i] * nums[j], (key) -> 0);
                k++;
                map.put(nums[i] * nums[j], k);
            }
        }
        int cnt = 0;
        for (int i : map.values()) {
            cnt += i * 8 * (i - 1) / 2;
        }
        return cnt;
    }
}
