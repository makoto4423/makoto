package problem1To100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a47permuteUnique {
    List<List<Integer>> res;
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        recur(new ArrayList<>(), nums);
        return res;
    }

    public void recur(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                recur(list, nums);
                list.remove(list.size() - 1);
                visited[i] = false;
                if (i != visited.length - 1) {
                    for (int j = i + 1; j < visited.length; j++) {
                        if (nums[j] == nums[i]) {
                            i++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

}
