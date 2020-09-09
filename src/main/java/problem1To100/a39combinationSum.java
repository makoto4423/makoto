package problem1To100;

import java.util.ArrayList;
import java.util.List;

public class a39combinationSum {
    List<List<Integer>> res;
    int[] candi;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        this.candi = candidates;
        this.target = target;
        if (candidates.length == 0 || target == 0) return res;
        recur(0, 0, new ArrayList<>());
        return res;
    }

    public void recur(int pos, int sum, List<Integer> list) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = pos; i < candi.length; i++) {
            if (sum + candi[i] > target) {
                continue;
            }
            list.add(candi[i]);
            recur(i, sum + candi[i], list);
            list.remove(list.size() - 1);
        }
    }
}
