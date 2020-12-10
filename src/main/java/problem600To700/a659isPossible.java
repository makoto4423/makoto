package problem600To700;

import java.util.*;

public class a659isPossible {
    public boolean isPossible(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i - 1)) {
                List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                list.add(0,1);
                map.put(i, list);
            } else {
                List<Integer> list = map.get(i - 1);
                // 保持插入有序就可以去掉排序，由于插入值只会是1，所以插入索引为0
                // Collections.sort(list);
                int first = list.get(0) + 1;
                list.remove(0);
                if (list.size() == 0) {
                    map.remove(i - 1);
                } else {
                    map.put(i - 1, list);
                }
                List<Integer> temp = map.getOrDefault(i, new ArrayList<>());
                temp.add(first);
                map.put(i, temp);
            }
        }
        for (int i : map.keySet()) {
            List<Integer> list = map.get(i);
            for (int j : list) {
                if (j < 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
