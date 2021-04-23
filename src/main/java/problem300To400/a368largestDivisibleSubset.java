package problem300To400;

import java.util.*;

public class a368largestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    Set<Integer> set = map.computeIfAbsent(i, k -> new HashSet<>());
                    set.add(j);
                }
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i : nums) {
            List<Integer> l = new LinkedList<>();
            l.add(i);
            lists.add(l);
        }
        for (int i = 1; i < n; i++) {
            int nowCount = 0, select = -1;
            if (map.get(i) != null) {
                for (Integer j : map.get(i)) {
                    if (lists.get(j).size() > nowCount) {
                        nowCount = lists.get(j).size();
                        select = j;
                    }
                }
            }
            if (select != -1) {
                lists.get(i).addAll(lists.get(select));
            }
        }
        int maxCount = -1;
        List<Integer> res = new ArrayList<>();
        for (List<Integer> l : lists) {
            if (l.size() > maxCount) {
                maxCount = l.size();
                res = l;
            }
        }
        return res;
    }
}
