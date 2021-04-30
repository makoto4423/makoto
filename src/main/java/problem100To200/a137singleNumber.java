package problem100To200;

import java.util.HashMap;
import java.util.Map;

public class a137singleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                int c = map.get(i);
                if (c == 2) {
                    map.remove(i);
                } else {
                    map.put(i, c + 1);
                }
            } else {
                map.put(i, 1);
            }
        }
        for (int i : map.keySet()) {
            return i;
        }
        return -1;
    }
}
