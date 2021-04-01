package problem1To100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 回溯，不在状态，回溯都不会写了
@Deprecated
public class a90subsetsWithDup {

    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        recur(nums, new ArrayList<>(), 0, false);
        return res;
    }

    public void recur(int[] num, List<Integer> list, int index, boolean choosePre) {
        if (index == num.length) {
            res.add(new ArrayList<>(list));
        } else {
            recur(num, list, index + 1, false);
            if (!choosePre && index > 0 && num[index - 1] == num[index]) {
                return;
            }
            list.add(num[index]);
            recur(num, list, index + 1, true);
            list.remove(list.size() - 1);
        }
    }
}
