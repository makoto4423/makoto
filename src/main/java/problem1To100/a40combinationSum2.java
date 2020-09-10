package problem1To100;

import java.util.*;

public class a40combinationSum2 {
    List<List<Integer>> res;
    int[] candi;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        this.candi = candidates;
        Arrays.sort(candi);
        if (target == 0 || candidates.length == 0) return res;
        recur(0, target, new ArrayList<>());
        return res;
    }

    public void recur(int pos, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pos; i < candi.length; i++) {
            list.add(candi[i]);
            recur(i + 1, target - candi[i], list);
            list.remove(list.size() - 1);
            while (i < candi.length - 1 && candi[i + 1] == candi[i]) {
                i++;
            }
        }
    }

}
