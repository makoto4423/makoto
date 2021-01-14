package problem1000To1100;

import java.util.ArrayList;
import java.util.List;

public class a1018prefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int val = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i : A) {
            val = (val<<1) + i;
            res.add(val % 5 == 0);
            val %= 5;
        }
        return res;
    }
}
