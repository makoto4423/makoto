package problem200To300;

import java.util.ArrayList;
import java.util.List;

public class a216combinationSum3 {

    List<List<Integer>> res;
    int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        this.k = k;
        if(k == 0 || n == 0)    return res;
        recur(n, 1, new ArrayList<>());
        return res;
    }

    public void recur(int n, int pos, List<Integer> list) {
        if (list.size() == k) {
            if (n == 0) res.add(new ArrayList<>(list));
            return;
        }
        for (int i = pos; i < 10; i++) {
            list.add(i);
            recur(n - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


}
