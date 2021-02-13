package problem400To500;

import java.util.ArrayList;
import java.util.List;

public class a448findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        for (int i : nums) {
            visited[i] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
