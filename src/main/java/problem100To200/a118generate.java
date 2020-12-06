package problem100To200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a118generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        list.add(Collections.singletonList(1));
        while (numRows != 1) {
            List<Integer> last = list.get(list.size() - 1);
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int i = 1; i < last.size(); i++) {
                next.add(last.get(i - 1) + last.get(i));
            }
            next.add(1);
            list.add(next);
            numRows--;
        }
        return list;
    }
}
